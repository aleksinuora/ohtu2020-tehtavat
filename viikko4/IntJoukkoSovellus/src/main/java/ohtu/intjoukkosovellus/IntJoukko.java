
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm = 0;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alkiot = new int[KAPASITEETTI];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        alkiot = new int[kapasiteetti];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Laiton kasvatuskoko");//heitin vaan jotain :D
        }
        alkiot = new int[kapasiteetti];
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            alkiot[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!kuuluu(luku)) {
            alkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % alkiot.length == 0) {
                int[] taulukkoOld = new int[alkiot.length];
                taulukkoOld = alkiot;
                kopioiTaulukko(alkiot, taulukkoOld);
                alkiot = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukkoOld, alkiot);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int poistetunIndeksi = -1;
        int alkio;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                poistetunIndeksi = i; //siis luku löytyy tuosta kohdasta :D
                alkiot[poistetunIndeksi] = 0;
                break;
            }
        }
        if (poistetunIndeksi != -1) {
            for (int j = poistetunIndeksi; j < alkioidenLkm - 1; j++) {
                alkio = alkiot[j];
                alkiot[j] = alkiot[j + 1];
                alkiot[j + 1] = alkio;
            }
            alkioidenLkm--;
            return true;
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        switch (alkioidenLkm) {
            case 0:
                return "{}";
            case 1:
                return "{" + alkiot[0] + "}";
            default:
                String tuotos = "{";
                for (int i = 0; i < alkioidenLkm - 1; i++) {
                    tuotos += alkiot[i];
                    tuotos += ", ";
                }
                tuotos += alkiot[alkioidenLkm - 1];
                tuotos += "}";
                return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(alkiot, 0, taulu, 0, taulu.length);
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        } 
        return z;
    }        
}
