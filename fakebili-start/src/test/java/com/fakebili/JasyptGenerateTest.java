package com.fakebili;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Emilelu
 * @version 0.1.0 2022/11/27 23:11:42
 * @since 0.1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JasyptGenerateTest {
    @Autowired
    StringEncryptor encryptor;

    @Value("${jasypt.encryptor.property.prefix}")
    String prefix;

    @Value("${jasypt.encryptor.property.suffix}")
    String suffix;

    @Test
    public void generate() {
        String[] list = new String[]{
                "test"
        };
        for (String s : list) {
            System.out.println(prefix + encryptor.encrypt(s) + suffix);
        }
    }
}
