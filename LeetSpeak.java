package KatasSolution;

class Leetspeak implements Encoder {


    @Override
    public String encode(String gelen) {
        return gelen == null ? "" : gelen.replaceAll("[aA]", "4").replaceAll("[eE]", "3").replaceAll("[lL]", "1").replaceAll("[mM]", "/^^\\\\").replaceAll("[oO]", "0").replaceAll("[uU]", "(_)");
    }
}

interface Encoder {
    String encode(String gelen);
}