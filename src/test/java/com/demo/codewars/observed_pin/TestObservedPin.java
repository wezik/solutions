package com.demo.codewars.observed_pin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestObservedPin {

    public static HashMap<String, String[]> expectations = new HashMap<String, String[]>() {
        {
            put("2", new String[]{"1", "2", "3", "5"});
            put("8", new String[]{"5", "7", "8", "9", "0"});
            put("0", new String[]{"0", "8"});
            put("11", new String[]{"11", "21", "41", "12", "22", "42", "14", "24", "44"});
            put("58", new String[]{"20", "25", "27", "28", "29", "40", "45", "47", "48", "49", "50", "55", "57", "58", "59", "60", "65", "67", "68", "69", "80", "85", "87", "88", "89"});
            put("46", new String[]{"13", "15", "16", "19", "43", "45", "46", "49", "53", "55", "56", "59", "73", "75", "76", "79"});
            put("369", new String[]{"236", "238", "239", "256", "258", "259", "266", "268", "269", "296", "298", "299", "336", "338", "339", "356", "358", "359", "366", "368", "369", "396", "398", "399", "636", "638", "639", "656", "658", "659", "666", "668", "669", "696", "698", "699"});
            put("007", new String[]{"004", "007", "008", "084", "087", "088", "804", "807", "808", "884", "887", "888"});
            put("9173", new String[]{"6142", "6143", "6146", "6172", "6173", "6176", "6182", "6183", "6186", "6242", "6243", "6246", "6272", "6273", "6276", "6282", "6283", "6286", "6442", "6443", "6446", "6472", "6473", "6476", "6482", "6483", "6486", "8142", "8143", "8146", "8172", "8173", "8176", "8182", "8183", "8186", "8242", "8243", "8246", "8272", "8273", "8276", "8282", "8283", "8286", "8442", "8443", "8446", "8472", "8473", "8476", "8482", "8483", "8486", "9142", "9143", "9146", "9172", "9173", "9176", "9182", "9183", "9186", "9242", "9243", "9246", "9272", "9273", "9276", "9282", "9283", "9286", "9442", "9443", "9446", "9472", "9473", "9476", "9482", "9483", "9486"});
            put("1357", new String[]{"1224", "1227", "1228", "1244", "1247", "1248", "1254", "1257", "1258", "1264", "1267", "1268", "1284", "1287", "1288", "1324", "1327", "1328", "1344", "1347", "1348", "1354", "1357", "1358", "1364", "1367", "1368", "1384", "1387", "1388", "1624", "1627", "1628", "1644", "1647", "1648", "1654", "1657", "1658", "1664", "1667", "1668", "1684", "1687", "1688", "2224", "2227", "2228", "2244", "2247", "2248", "2254", "2257", "2258", "2264", "2267", "2268", "2284", "2287", "2288", "2324", "2327", "2328", "2344", "2347", "2348", "2354", "2357", "2358", "2364", "2367", "2368", "2384", "2387", "2388", "2624", "2627", "2628", "2644", "2647", "2648", "2654", "2657", "2658", "2664", "2667", "2668", "2684", "2687", "2688", "4224", "4227", "4228", "4244", "4247", "4248", "4254", "4257", "4258", "4264", "4267", "4268", "4284", "4287", "4288", "4324", "4327", "4328", "4344", "4347", "4348", "4354", "4357", "4358", "4364", "4367", "4368", "4384", "4387", "4388", "4624", "4627", "4628", "4644", "4647", "4648", "4654", "4657", "4658", "4664", "4667", "4668", "4684", "4687", "4688"});
            put("00000000", new String[]{"00000000", "00000008", "00000080", "00000088", "00000800", "00000808", "00000880", "00000888", "00008000", "00008008", "00008080", "00008088", "00008800", "00008808", "00008880", "00008888", "00080000", "00080008", "00080080", "00080088", "00080800", "00080808", "00080880", "00080888", "00088000", "00088008", "00088080", "00088088", "00088800", "00088808", "00088880", "00088888", "00800000", "00800008", "00800080", "00800088", "00800800", "00800808", "00800880", "00800888", "00808000", "00808008", "00808080", "00808088", "00808800", "00808808", "00808880", "00808888", "00880000", "00880008", "00880080", "00880088", "00880800", "00880808", "00880880", "00880888", "00888000", "00888008", "00888080", "00888088", "00888800", "00888808", "00888880", "00888888", "08000000", "08000008", "08000080", "08000088", "08000800", "08000808", "08000880", "08000888", "08008000", "08008008", "08008080", "08008088", "08008800", "08008808", "08008880", "08008888", "08080000", "08080008", "08080080", "08080088", "08080800", "08080808", "08080880", "08080888", "08088000", "08088008", "08088080", "08088088", "08088800", "08088808", "08088880", "08088888", "08800000", "08800008", "08800080", "08800088", "08800800", "08800808", "08800880", "08800888", "08808000", "08808008", "08808080", "08808088", "08808800", "08808808", "08808880", "08808888", "08880000", "08880008", "08880080", "08880088", "08880800", "08880808", "08880880", "08880888", "08888000", "08888008", "08888080", "08888088", "08888800", "08888808", "08888880", "08888888", "80000000", "80000008", "80000080", "80000088", "80000800", "80000808", "80000880", "80000888", "80008000", "80008008", "80008080", "80008088", "80008800", "80008808", "80008880", "80008888", "80080000", "80080008", "80080080", "80080088", "80080800", "80080808", "80080880", "80080888", "80088000", "80088008", "80088080", "80088088", "80088800", "80088808", "80088880", "80088888", "80800000", "80800008", "80800080", "80800088", "80800800", "80800808", "80800880", "80800888", "80808000", "80808008", "80808080", "80808088", "80808800", "80808808", "80808880", "80808888", "80880000", "80880008", "80880080", "80880088", "80880800", "80880808", "80880880", "80880888", "80888000", "80888008", "80888080", "80888088", "80888800", "80888808", "80888880", "80888888", "88000000", "88000008", "88000080", "88000088", "88000800", "88000808", "88000880", "88000888", "88008000", "88008008", "88008080", "88008088", "88008800", "88008808", "88008880", "88008888", "88080000", "88080008", "88080080", "88080088", "88080800", "88080808", "88080880", "88080888", "88088000", "88088008", "88088080", "88088088", "88088800", "88088808", "88088880", "88088888", "88800000", "88800008", "88800080", "88800088", "88800800", "88800808", "88800880", "88800888", "88808000", "88808008", "88808080", "88808088", "88808800", "88808808", "88808880", "88808888", "88880000", "88880008", "88880080", "88880088", "88880800", "88880808", "88880880", "88880888", "88888000", "88888008", "88888080", "88888088", "88888800", "88888808", "88888880", "88888888"});
        }
    };
    private final static Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);

    @Test
    public void testPins() {
        for (String entered : expectations.keySet()) {
            test(entered, Arrays.asList(expectations.get(entered)), ObservedPin.getPINs(entered));
        }
    } // testPins

    private void test(String entered, List<String> expected, List<String> result) {
        result.sort(comp);
        expected.sort(comp);
        assertEquals(expected, result);
    }

    private int random(int a, int b) {
        return (int) (Math.random() * (b - a + 1) + a);
    }

    @Test
    public void randomPins() {
        for (int i = 0; i < 10; i++) {
            String entered = "";
            for (int j = 0; j < random(2, 6); j++) {
                entered += random(0, 9);
                test(entered, TestObservedPin.getPINs(entered), ObservedPin.getPINs(entered));
            }
        }
    }

    // To calculate results of random tests

    private static HashMap<Character, List<String>> mapping = new HashMap<Character, List<String>>() {
        {
            put('0', Arrays.asList("0", "8"));
            put('1', Arrays.asList("1", "2", "4"));
            put('2', Arrays.asList("1", "2", "3", "5"));
            put('3', Arrays.asList("2", "3", "6"));
            put('4', Arrays.asList("1", "4", "5", "7"));
            put('5', Arrays.asList("2", "4", "5", "6", "8"));
            put('6', Arrays.asList("3", "5", "6", "9"));
            put('7', Arrays.asList("4", "7", "8"));
            put('8', Arrays.asList("0", "5", "7", "8", "9"));
            put('9', Arrays.asList("6", "8", "9"));
        }
    };

    private static List<String> getPINs(String observed) {
        LinkedList<String> result = new LinkedList<>();
        if (observed != null && !observed.isEmpty()) {
            result.addAll(mapping.get(observed.charAt(0)));
            for (int i = 1; i < observed.length(); i++) {
                LinkedList<String> temp = new LinkedList<>();
                for (String s1 : result)
                    for (String s2 : mapping.get(observed.charAt(i)))
                        temp.add(s1 + s2);
                result = temp;
            } // for i
        }// if observed
        return result;
    } // getPINs

} // Test Class