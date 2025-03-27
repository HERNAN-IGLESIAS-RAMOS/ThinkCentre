public class Tornillo {
    private double longitud;
    private double diametro;
    private String huella; // "Plana", "Cruz", "Pozidriv", "Torx"

    // (a) Constructores
    public Tornillo() {
        this.longitud = 30.0;
        this.diametro = 6.0;
        this.huella = "Plana";
    }

    public Tornillo(double longitud, double diametro) {
        this.longitud = longitud;
        this.diametro = diametro;
        this.huella = "Cruz";
    }

    public Tornillo(double longitud, double diametro, String huella) {
        this.longitud = longitud;
        this.diametro = diametro;
        this.huella = huella;
    }

    public Tornillo(Tornillo otro) {
        this.longitud = otro.longitud;
        this.diametro = otro.diametro;
        this.huella = otro.huella;
    }

    // (b) Métodos set() y get()
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        if (longitud > 0) {
            this.longitud = longitud;
        } else {
            System.out.println("Error: La longitud debe ser mayor que 0.");
        }
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        if (diametro > 0) {
            this.diametro = diametro;
        } else {
            System.out.println("Error: El diámetro debe ser mayor que 0.");
        }
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        if (huella.equals("Plana") || huella.equals("Cruz") || huella.equals("Pozidriv") || huella.equals("Torx")) {
            this.huella = huella;
        } else {
            System.out.println("Error: Huella no válida.");
        }
    }

    // (c) Método esCompatible()
    public boolean esCompatible(Tornillo otro) {
        if (this.huella.equals(otro.huella)) {
            return true; // Mismo tipo de huella
        } else if (this.huella.equals("Plana") && (otro.huella.equals("Cruz") || otro.huella.equals("Pozidriv"))) {
            return true;
        } else if (this.huella.equals("Cruz") && otro.huella.equals("Pozidriv")) {
            return true;
        }
        return false;
    }

    // (d) Método toString()
    @Override
    public String toString() {
        return "Tornillo: Longitud=" + longitud + ", Diámetro=" + diametro + ", Huella=" + huella;
    }
}