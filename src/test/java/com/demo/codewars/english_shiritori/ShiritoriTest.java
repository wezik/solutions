package com.demo.codewars.english_shiritori;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ShiritoriTest {
        private static Shiritori S;
        @BeforeAll
        public static void Init()
        {
            S = new Shiritori();

        }
        @Test
        public void test1()
        {
            ArrayList<String> words = new ArrayList<String>(Arrays.asList("dog","goose","elephant","tiger","rhino","orc","cat"));
            List<String> expected = new ArrayList<String>(Arrays.asList("dog","goose"
                    ,"elephant","tiger","rhino","orc", "cat"));
            assertEquals(expected, S.theGame(words));

        }
        @Test
        public void test2()
        {

            ArrayList<String> words = new ArrayList<String>(Arrays.asList("dog","goose","tiger","cat", "elephant","rhino","orc"));
            List<String> expected = new ArrayList<String>(Arrays.asList("dog","goose"));
            assertEquals(expected, S.theGame(words));

        }
        @Test
        public void test3()
        {

            ArrayList<String> words = new ArrayList<String>(Arrays.asList("dog","goose","elephant","tiger","cat" ,"rhino","rhino","orc"));
            List<String> expected = new ArrayList<String>(Arrays.asList("dog","goose"
                    ,"elephant","tiger"));
            assertEquals(expected, S.theGame(words));

        }
        @Test
        public void TestEmpty()
        {
            ArrayList<String> words = new ArrayList<String>();
            assertEquals(new ArrayList<String>(), S.theGame(words));

        }
        @Test
        public void TestEStrings()
        {
            ArrayList<String> words = new ArrayList<String>(Arrays.asList("","","","","","",""));
            assertEquals(new ArrayList<String>(), S.theGame(words));
        }
        @Test
        public void TestMidEStrings()
        {
            ArrayList<String> words = new ArrayList<String>(Arrays.asList("ab","bc","","de","","",""));
            ArrayList<String> expected = new ArrayList<String>(Arrays.asList("ab","bc"));
            assertEquals(expected, S.theGame(words));
        }
        @Test
        public void RandomTests()
        {
            ShiritoriCheck SC = new ShiritoriCheck();
            ArrayList<String> randomWords = new ArrayList<String>(Arrays.asList("dog","goose","tiger","cat", "elephant","rhino","orc",
                    "leopard", "spanish", "english", "german", "japanese","chinese",
                    "taco","burrito","enchilada","potato","fries","wings","ramen",
                    "spaghetti","curry","nutella","apple","yams","tabasco","ketchup","mustard",
                    "broccoli","ice","hamburger", "", "soup","poutine","olives","spinach"));

            Random rand = new Random();
            for(int k = 0; k < 25; k++)
            {
                int length = randomWords.size()-1;

                ArrayList<String> wordList = new ArrayList<String>();

                for(int i = 0; i < 10; i++)
                {
                    String randomS = randomWords.get(rand.nextInt(length));
                    wordList.add(randomS);

                }
                List<String> expected = SC.theGame(wordList);

                List<String> actual = S.theGame(wordList);
                assertEquals(expected, actual);
            }

        }

        public class ShiritoriCheck
        {
            public List<String> theGame(ArrayList<String> words)
            {
                if(words.isEmpty()|| words.get(0).equals("")){return new ArrayList<String>();}
                ArrayList<String> retList = new ArrayList<String>();
                retList.add(words.get(0));
                for(int i = 0; i < words.size()-1; i++)
                {
                    if(words.get(i+1).equals(""))
                    {
                        return retList;
                    }
                    char end = ' ';
                    char beg = ' ';
                    if(!words.get(i).equals("") && !words.get(i+1).equals(""))
                    {
                        end = words.get(i).charAt(words.get(i).length()-1);
                        beg =  words.get(i+1).charAt(0);
                    }

                    if(end==beg)
                    {
                        retList.add(words.get(i+1));
                    }
                    else
                    {
                        return retList;
                    }


                }
                return retList;
            }

        }
    }
