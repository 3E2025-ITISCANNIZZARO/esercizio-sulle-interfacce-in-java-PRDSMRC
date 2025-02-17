// Interfaccia Personaggio
public interface Personaggio {
    void combatti();
    int getForzaFisica();
}

// Classe astratta Umano
public abstract class Umano implements Personaggio {
    protected int forzaFisica = 10;

    @Override
    public int getForzaFisica() {
        return forzaFisica;
    }
}

// Classe astratta Extraterrestre
public abstract class Extraterrestre implements Personaggio {
    protected int forzaFisica = 15;

    @Override
    public int getForzaFisica() {
        return forzaFisica;
    }
}

// Classe SuperEroe
public class SuperEroe extends Umano {
    @Override
    public void combatti() {
        forzaFisica -= 3;
    }
}

// Classe Vampiro
public class Vampiro extends Extraterrestre {
    @Override
    public void combatti() {
        forzaFisica -= 2;
    }
}

// Classe Licantropo
public class Licantropo extends Umano {
    private boolean notteLunaPiena;

    public Licantropo(boolean notteLunaPiena) {
        this.notteLunaPiena = notteLunaPiena;
        if (notteLunaPiena) {
            forzaFisica = 15;
        } else {
            forzaFisica = 10;
        }
    }

    @Override
    public void combatti() {
        if (notteLunaPiena) {
            forzaFisica -= 2;
        } else {
            forzaFisica -= 3;
        }
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        SuperEroe superEroe = new SuperEroe();
        Vampiro vampiro = new Vampiro();
        Licantropo licantropoLunaPiena = new Licantropo(true);
        Licantropo licantropoNonLunaPiena = new Licantropo(false);

        // SuperEroe combatte tre volte
        superEroe.combatti();
        superEroe.combatti();
        superEroe.combatti();

        // Vampiro combatte una volta
        vampiro.combatti();

        // Licantropo combatte due volte
        licantropoLunaPiena.combatti();
        licantropoNonLunaPiena.combatti();

        // Stampa della forza fisica rimanente
        System.out.println("Forza fisica SuperEroe: " + superEroe.getForzaFisica());
        System.out.println("Forza fisica Vampiro: " + vampiro.getForzaFisica());
        System.out.println("Forza fisica Licantropo (Luna Piena): " + licantropoLunaPiena.getForzaFisica());
        System.out.println("Forza fisica Licantropo (Non Luna Piena): " + licantropoNonLunaPiena.getForzaFisica());
    }
}
