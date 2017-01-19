package com.mission.interview.algos;
public class Solution {
    public int compareVersion(String version1, String version2) {
         Integer level1 = Integer.parseInt(version1.split("\\.")[0]);
            Integer level2 = Integer.parseInt(version2.split("\\.")[0]);
        if(version1.indexOf(".")<0 && version2.indexOf(".")<0){
                 return level1>level2 ? 1:( (level1==level2) ? 0 : -1);
                }
          
            else if(version1.indexOf("\\.") <0 && version2.indexOf("\\.")>0){
                 return compareVersion("0", version2.split("\\.")[1]);
                }
               else if(version1.indexOf("\\.")>0 && version2.indexOf("\\.")<0){
                 return compareVersion(version1.split("\\.")[1], "0");
                }
                else{
                    if(level1==level2){
                      return compareVersion(version1.split("\\.")[1], version2.split("\\.")[1]);
                }
                else{
                     return level1>level2 ? 1:( (level1==level2) ? 0 : -1);
                }
            }
    }
    
    
    public static void main(String arg[]){
    	Solution s = new Solution();
    	System.out.println(s.compareVersion("1.0", "1.1"));
    }
    
}