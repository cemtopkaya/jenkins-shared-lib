import java.io.*;
import groovy.io.*;
import java.util.regex.*;
import Parser.AngularParser;
//import tr.com.cinar;

// def url = new URL("file://C:/_dev/jenkins/calismalar/sharedlib-repo/src/")
// this.getClass().classLoader.rootLoader.addURL(url)

def map = AngularParser.parseJson()
println map
map.eachWithIndex { entry, index ->
    def indent = ((index == 0 || index % 2 == 0) ? "   " : "")
    println "$index $entry.key $entry.value.path $entry.value.dependencies"
}

// Map.Entry<String, Paket> 
// def entry = map.keySet().stream().findFirst()
// map.each { entry -> println "Hex Code: $entry.key = Color Name: $entry.value" }
// println map.values().class.name
