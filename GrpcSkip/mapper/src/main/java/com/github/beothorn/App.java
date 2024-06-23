package com.github.beothorn;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Mapper is running." );
    }

    public static void intercept(Object... args) {
        System.out.println("Received " + Arrays.toString(args));
    }
}
