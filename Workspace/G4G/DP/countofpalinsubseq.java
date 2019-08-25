 int countPS(String str)
    {
        int[][] strg = new int[str.length()][str.length()];
        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=i+gap;j<str.length();i++,j++){
                if(gap==0){
                    strg[i][j]=1;
                }else if(gap==1){
                    if(str.charAt(i)==str.charAt(j)){
                        strg[i][j]=3;
                    }else{
                        strg[i][j]=2;
                    }
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        strg[i][j]=strg[i+1][j]+strg[i][j-1]+1;
                    }else{
                        strg[i][j]=strg[i+1][j]+strg[i][j-1]-strg[i+1][j-1];
                    }
                }
            }
        }
        return strg[0][str.length()-1];
    }
