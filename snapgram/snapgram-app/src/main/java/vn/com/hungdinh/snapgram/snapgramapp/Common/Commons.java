package vn.com.hungdinh.snapgram.snapgramapp.Common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Commons {

    /**
     * 
     * @param valueCheck
     * @param valueCompare
     * @return
     */
    public static boolean checkEncodeString(String valueCheck, String valueEncode) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(valueCheck, valueEncode)) {
            return true;
        }
        return false;
    }
}
