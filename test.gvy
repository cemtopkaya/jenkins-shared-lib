import java.io.*;
import groovy.io.*;
import java.util.regex.*;
import Parser.AngularParser;
import Sorter.BuildSorter; 

// def url = new URL("file://C:/_dev/jenkins/calismalar/sharedlib-repo/src/")
// this.getClass().classLoader.rootLoader.addURL(url)

def projectPath = "C:/Users/cem.topkaya/git/gui_nrf_test/angular.json"
def map = AngularParser.parseJson(projectPath)
//println map
res = BuildSorter.getSortedLibraries(map)
println ""
println ""
println res
/*
map.eachWithIndex { entry, index ->
    def indent = ((index == 0 || index % 2 == 0) ? "   " : "")
    println "$index $entry.key $entry.value.path $entry.value.dependencies"
}

println "---------------------"


*/