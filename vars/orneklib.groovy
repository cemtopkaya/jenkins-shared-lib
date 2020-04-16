import Parser.AngularParser;
import Sorter.BuildSorter; 

@NonCPS
def call() {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    println "Merhaba, Cengoooo."
    
    def projectPath = "C:/Users/cem.topkaya/git/gui_nrf_test/"
    def map = AngularParser.parseAngularJson(projectPath)
    //println map
    res = BuildSorter.getSortedLibraries(map)
    res.each {
        l->println l
    }

}