//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ws.schild.jave;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// 根据MultimediaObject改造而来
public class FFmpegFileInfo {
    private static final Log LOG = LogFactory.getLog(MultimediaObject.class);
    private static final Pattern SIZE_PATTERN = Pattern.compile("(\\d+)x(\\d+)", 2);
    private static final Pattern FRAME_RATE_PATTERN = Pattern.compile("([\\d.]+)\\s+(?:fps|tbr)", 2);
    private static final Pattern BIT_RATE_PATTERN = Pattern.compile("(\\d+)\\s+kb/s", 2);
    private static final Pattern SAMPLING_RATE_PATTERN = Pattern.compile("(\\d+)\\s+Hz", 2);
    private static final Pattern CHANNELS_PATTERN = Pattern.compile("(mono|stereo|quad)", 2);
    private final FFMPEGLocator locator;
    private File inputFile;
    private URL inputURL;

    public FFmpegFileInfo(File input) {
        this.locator = new DefaultFFMPEGLocator();
        this.inputFile = input;
    }

    public FFmpegFileInfo(URL input) {
        this.locator = new DefaultFFMPEGLocator();
        this.inputURL = input;
    }

    public File getFile() {
        return this.inputFile;
    }

    public URL getURL() {
        return this.inputURL;
    }

    public void setFile(File file) {
        this.inputFile = file;
    }

    public void setUR(URL input) {
        this.inputURL = input;
    }

    public boolean isURL() {
        return this.inputURL != null;
    }

    public FFmpegFileInfo(File input, FFMPEGLocator locator) {
        this.locator = locator;
        this.inputFile = input;
    }

    public MultimediaInfo getInfo(String url) throws InputFormatException, EncoderException {
        FFMPEGExecutor ffmpeg = this.locator.createExecutor();
        ffmpeg.addArgument("-i");
        ffmpeg.addArgument(url);

        try {
            ffmpeg.execute();
        } catch (IOException var7) {
            throw new EncoderException(var7);
        }

        MultimediaInfo var3;
        try {
            RBufferedReader reader = new RBufferedReader(new InputStreamReader(ffmpeg.getErrorStream()));
            if (!this.isURL()) {
                var3 = this.parseMultimediaInfo(this.inputFile.getAbsolutePath(), reader);
                return var3;
            }

            var3 = this.parseMultimediaInfo(this.inputURL.toString(), reader);
        } finally {
            ffmpeg.destroy();
        }

        return var3;
    }

    private MultimediaInfo parseMultimediaInfo(String source, RBufferedReader reader) throws InputFormatException, EncoderException {
        Pattern p1 = Pattern.compile("^\\s*Input #0, (\\w+).+$\\s*", 2);
        Pattern p2 = Pattern.compile("^\\s*Duration: (\\d\\d):(\\d\\d):(\\d\\d)\\.(\\d\\d).*$", 2);
        Pattern p3 = Pattern.compile("^\\s*Stream #\\S+: ((?:Audio)|(?:Video)|(?:Data)): (.*)\\s*$", 2);
        Pattern p4 = Pattern.compile("^\\s*Metadata:", 2);
        MultimediaInfo info = null;

        try {
            int step = 0;

            while(true) {
                String line = reader.readLine();
                LOG.debug("Output line: " + line);
                if (line == null) {
                    break;
                }

//                Matcher m;
                String type;
                switch(step) {
                    case 0:
                        String token = source + ": ";
                        if (line.startsWith(token)) {
                            String message = line.substring(token.length());
                            throw new InputFormatException(message);
                        }

                        Matcher m = p1.matcher(line);
                        if (m.matches()) {
                            type = m.group(1);
                            info = new MultimediaInfo();
                            info.setFormat(type);
                            ++step;
                        }
                        break;
                    case 1:
                        m = p2.matcher(line);
                        if (m.matches()) {
                            long hours = (long)Integer.parseInt(m.group(1));
                            long minutes = (long)Integer.parseInt(m.group(2));
                            long seconds = (long)Integer.parseInt(m.group(3));
                            long dec = (long)Integer.parseInt(m.group(4));
                            long duration = dec * 10L + seconds * 1000L + minutes * 60L * 1000L + hours * 60L * 60L * 1000L;
                            info.setDuration(duration);
                            ++step;
                        }
                        break;
                    case 2:
                        m = p3.matcher(line);
                        p4.matcher(line);
                        if (m.matches()) {
                            type = m.group(1);
                            String specs = m.group(2);
                            StringTokenizer st;
                            int i;
//                            String token;
                            boolean parsed;
                            Matcher m2;
                            int bitRate;
                            if ("Video".equalsIgnoreCase(type)) {
                                VideoInfo video = new VideoInfo();
                                st = new StringTokenizer(specs, ",");

                                for(i = 0; st.hasMoreTokens(); ++i) {
                                    token = st.nextToken().trim();
                                    if (i == 0) {
                                        video.setDecoder(token);
                                    } else {
                                        parsed = false;
                                        m2 = SIZE_PATTERN.matcher(token);
                                        if (!parsed && m2.find()) {
                                            bitRate = Integer.parseInt(m2.group(1));
                                            int height = Integer.parseInt(m2.group(2));
                                            video.setSize(new VideoSize(bitRate, height));
                                            parsed = true;
                                        }

                                        m2 = FRAME_RATE_PATTERN.matcher(token);
                                        if (!parsed && m2.find()) {
                                            try {
                                                float frameRate = Float.parseFloat(m2.group(1));
                                                video.setFrameRate(frameRate);
                                            } catch (NumberFormatException var22) {
                                                LOG.info("Invalid frame rate value: " + m2.group(1), var22);
                                            }

                                            parsed = true;
                                        }

                                        m2 = BIT_RATE_PATTERN.matcher(token);
                                        if (!parsed && m2.find()) {
                                            bitRate = Integer.parseInt(m2.group(1));
                                            video.setBitRate(bitRate * 1000);
                                            parsed = true;
                                        }
                                    }
                                }

                                info.setVideo(video);
                            } else if ("Audio".equalsIgnoreCase(type)) {
                                AudioInfo audio = new AudioInfo();
                                st = new StringTokenizer(specs, ",");

                                for(i = 0; st.hasMoreTokens(); ++i) {
                                    token = st.nextToken().trim();
                                    if (i == 0) {
                                        audio.setDecoder(token);
                                    } else {
                                        parsed = false;
                                        m2 = SAMPLING_RATE_PATTERN.matcher(token);
                                        if (!parsed && m2.find()) {
                                            bitRate = Integer.parseInt(m2.group(1));
                                            audio.setSamplingRate(bitRate);
                                            parsed = true;
                                        }

                                        m2 = CHANNELS_PATTERN.matcher(token);
                                        if (!parsed && m2.find()) {
                                            String ms = m2.group(1);
                                            if ("mono".equalsIgnoreCase(ms)) {
                                                audio.setChannels(1);
                                            } else if ("stereo".equalsIgnoreCase(ms)) {
                                                audio.setChannels(2);
                                            } else if ("quad".equalsIgnoreCase(ms)) {
                                                audio.setChannels(4);
                                            }

                                            parsed = true;
                                        }

                                        m2 = BIT_RATE_PATTERN.matcher(token);
                                        if (!parsed && m2.find()) {
                                            bitRate = Integer.parseInt(m2.group(1));
                                            audio.setBitRate(bitRate * 1000);
                                            parsed = true;
                                        }
                                    }
                                }

                                info.setAudio(audio);
                            }
                        }
                }

                if (line.startsWith("frame=")) {
                    reader.reinsertLine(line);
                    break;
                }
            }
        } catch (IOException var23) {
            throw new EncoderException(var23);
        }

        if (info == null) {
            throw new InputFormatException();
        } else {
            return info;
        }
    }
}
