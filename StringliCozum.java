package KatasSolution

class StringliCozum {

    static String toCamelCase(String s){

        boolean check = false;
        String cevap = "";
        String [] dizicik;
        for (int i = 0 ; i< s.length() ; i++){
            if (s.charAt(i) == '-'){
                check = true;
                break;
            }
        }
        if (check){
            dizicik = s.split("-");
        }
        else
            dizicik = s.split("_");

        cevap += dizicik[0];

        for (int i = 1 ; i < dizicik.length ; i ++){
            dizicik[i] = dizicik[i].substring(0,1).toUpperCase() + dizicik[i].substring(1);
            cevap += dizicik[i];
        }
        return cevap;
    }
}