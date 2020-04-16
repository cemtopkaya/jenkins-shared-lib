import  Paket
import java.io.*;
import groovy.io.*;
import java.util.regex.Pattern

//package tr.com.cinar.Parser

class PackageParser {

    def static ArrayList parseJson(String jsonPath="C:\\Users\\cem.topkaya\\git\\gui_nrf_test\\projects\\cinar\\cn-nef\\package.json"){
        def res = []
        
        def lines = new File(jsonPath).readLines()

        lines.eachWithIndex((line, idx)->{
            def matcher = line =~ /^\s+("(@cinar.*?)")/
            if(matcher.size()>0){
                def dependency = matcher[0][0].trim().replaceAll("\"","")
                res.add(dependency)
            }
        })

        return res.size()>0 ? res : null;
    }

}
