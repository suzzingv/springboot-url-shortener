package com.prgrms.shorturl.utils;

import com.prgrms.shorturl.exception.HashingException;
import lombok.RequiredArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RequiredArgsConstructor
public class HashFactory {
    private final HashAlgorithm algorithm;

    public String generate(String originalUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(originalUrl.getBytes("UTF-8"));
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new HashingException("hashing 도중 오류가 발생했습니다.");
        }
    }
}
