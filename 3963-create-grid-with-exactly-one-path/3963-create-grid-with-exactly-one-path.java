class Solution {
    public String[] createGrid(int m, int n) {
        String grid[] = new String[m] ;
    String s = ".".repeat( n ) ;
    grid[ 0 ] = s ;
    for( int i = 1 ; i < m ; i++ ){
        String s1 = "#".repeat( n-1 ) ;
        s1 += "." ;
        grid[ i ] = s1 ;
    }
    return grid ;
    }
}