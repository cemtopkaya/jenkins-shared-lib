import  Paket
import java.io.*;
import groovy.io.*;
import java.util.regex.Pattern

//package tr.com.cinar.Parser

class AngularParser {

    def static Map<String, Paket> parseJson(String jsonPath="C:\\Users\\cem.topkaya\\git\\gui_nrf_test\\angular.json"){
        def res = [:]
        
        def lines = new File(jsonPath).readLines()

        lines.eachWithIndex((line, idx)->{
            def reg =  ~/.*"projectType": "library",/
            if(reg.matcher(line).matches()){
                // println "${idx} \t Current Line: ${line} \t Prev Line: ${lines[idx-1]} \t Next Line: ${lines[idx+1]}"
                // lines[idx-1].grep(~/(@cinar.*)>?"/){ match, a -> name = a }
                // lines[idx+1].grep(~/(projects.*)>?"/){ match, a -> root = a }
                def matcher = lines[idx+1] =~ /(projects.*)>?"/
                def root = matcher[0][0]
                matcher = lines[idx-1] =~ ~/(@cinar.*)>?"/
                def name = matcher[0][0]
                
                //println "Name: ${name} , Path: ${root}"
                res.put(name, new Paket(name, root))
            }
        })

        return res
    }

}
