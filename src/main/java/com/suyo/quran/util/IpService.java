package com.suyo.quran.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@Log4j2
public class IpService {
    public static Map<String, Object> ipGetLocation(String ip) {
        try {
            Map<String, Object> ipInfo = new HashMap<>();
            ipInfo.put("ip", ip);
            return ipInfo;
        } catch (Exception e) {
            log.error(e.getMessage());
            return Map.of("ip", ip, "countryCode", "UZ");
        }
    }

    private static File getFileFromResource() throws URISyntaxException {
        return new File(Objects.requireNonNull(IpService.class.getClassLoader().getResource("geolite/GeoLite2-City.mmdb")).toURI());
    }
}
