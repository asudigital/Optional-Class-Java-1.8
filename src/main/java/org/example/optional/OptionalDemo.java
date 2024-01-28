package org.example.optional;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args){

//      NOTE- optional.of() and optional.ofNullable() make a optionalClass Object from non-optional class Object

        String email = "asutosh@gmail.com";
        String email2 = null ;
        // of , empty , ofNullable-- 3 static methods
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

       Optional<String> emailOptional = Optional.of(email);
        System.out.println(emailOptional);

        //Optional.of() throws null pointer exception, while we pass null object to it
//        Optional<String>   emailOptional2 = Optional.of(email2);
//        System.out.println(emailOptional2);

//        ofNullable() Method, if won't throw null pointer exception , if the object may or may not be null then use this method
//        in case of empty object it throws empty optional object , internally handles null pointer exception

        Optional<String> stringOptional= Optional.ofNullable(email);
        System.out.println(stringOptional);

        Optional<String> stringOptional2 = Optional.ofNullable(email2);
        System.out.println(stringOptional2);
 //OPTIONAL IS A SINGLE VALUE CONTAINER
 // to get the value from optional class object we use get() method

        System.out.println(stringOptional.get());

        //We are trying to get the value from the empty optional object, so NoSuchElementException will be there , in real world before this we always
        // use isPresent() method

//        System.out.println(stringOptional2.get());

        if(stringOptional.isPresent()){
            System.out.println(stringOptional.get() + " hiiiii");
        }
        else {
            System.out.println("no value present");
        }

        if(stringOptional2.isPresent()){
            System.out.println(stringOptional.get());
        }
        else {
            System.out.println("no value present");
        }

//        orElse() Method
// By this we will get a default value
        String defaultOptional = stringOptional.orElse("default@gmail.com");
        System.out.println(defaultOptional);

        String defaultOptional2 = stringOptional2.orElse("default@gmail.com");
        System.out.println(defaultOptional2);

//        orElseGet() Method , uses supplier functional interface , so we need to apply () ->
        String s = stringOptional.orElseGet(() -> "default@gmail.com");
        System.out.println(s + " "  + "Asutosh");

        String s1 = stringOptional2.orElseGet(() -> "default@gmail.com");
        System.out.println(s1);
 //Throws Null Pointer Exception , if no value is present and the supplying function is null

//        String s2 = stringOptional2.orElseGet(null);
//        System.out.println(s1);

//        orElseThrow Method
//        Whenever the value is not present in optional class object , sometime we need to throws  exception

        String optionalObject = stringOptional.orElseThrow(() -> new IllegalArgumentException("Email is not exist"));
        System.out.println(optionalObject + " Asu");

//        String optionalObject2 = stringOptional2.orElseThrow(() -> new IllegalArgumentException("Email is not exist"));
//        System.out.println(optionalObject2 + " Asu");

//        ifPresent()  Method
        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptyOptional2 = Optional.empty();

       gender.ifPresent(   (w)-> System.out.println("value is  present"));

       //   emptyOptional2 contains null so the value i.e. System.out.println("it won't be executed")
        emptyOptional2.ifPresent( (w)->
            System.out.println ("value is not present") );

//        filter() Method

        String result = "Asutosh";
//        if( result != null && result.contains("Asutosh")){
//            System.out.println(result);
//        }

        Optional<String> result1 = Optional.of(result);
        result1.filter( (res )-> res.contains("Asutosh"))
                .ifPresent( (res) -> System.out.println(res));

//  filter Method and map method
        String testResult = "  Asutosh  Saho o  ";
        Optional<String> result3 = Optional.of(testResult);

        result3.filter( (q) -> q.contains("Asutosh  Saho") )
                .map(String::trim)
                .ifPresent( (res)-> System.out.println(res));

        // map method in Optional provides a way to transform value in optional from one type to another
    }
}
