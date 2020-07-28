package me.JuniorDeveloper.battlepass.helper;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Text {
    public static final char SECTION_CHAR = '§';
    public static final char AMPERSAND_CHAR = '&';

    private Text() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    public static String joinNewline(String... strings) {
        return joinNewline(Arrays.stream(strings));
    }

    public static String joinNewline(Stream<String> strings) {
        return (String) strings.collect(Collectors.joining("\n"));
    }

    public static String colorize(String s) {
        return s == null ? null : translateAlternateColorCodes('&', '§', s);
    }

    public static String decolorize(String s) {
        return s == null ? null : translateAlternateColorCodes('§', '&', s);
    }

    public static String translateAlternateColorCodes(char from, char to, String textToTranslate) {
        char[] b = textToTranslate.toCharArray();

        for (int i = 0; i < b.length - 1; ++i) {
            if (b[i] == from && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
                b[i] = to;
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }
}
