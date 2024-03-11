package campeonatoafa;

public class CampeonatoAFA {

    String[] equipos = {"Velez", "Chacarita", "Estudiantes", "Boca", "River", "Talleres", "Independiente", "Racing", "Rosario", "Lanus"};
    String[] equiposMixed = new String[10];
    int fecha=1;
    
    //Vectores de Tabla
    int[] puntos = new int[10];
    int[] partidosGanados = new int[10];
    int[] partidosEmpatados = new int[10];
    int[] partidosPerdidos = new int[10];
    int[] golesFavor = new int[10];
    int[] golesEncontra = new int[10];
    int[] diferenciaGoles = new int[10];
    
    //Metodo para mezclas los equipos y que se cree un torneo diferente cada vez
    public void mezclar(){
        
        System.out.println("----------Liga Profesional de Futbol----------");
        System.out.println("EQUIPOS A JUGAR:\n");
        
        //Muestro los equipos q participan en el torneo
        for(int i=0; i<10; i++){
            System.out.println(equipos[i]);
        }
        
        int x=0; //variable que va a guardar el iterador
        
        while(x<100){ //Blucle q repite 100 veces 
            int n1 = (int)(Math.random()*10);   //5
            int n2 = (int)(Math.random()*10);  //3
            
            if(n1 != n2){
                String aux; //variable q guarda el numero para intercambiar
                aux = equipos[n1];
                equipos[n1] = equipos[n2];
                equipos[n2] = aux;
            }
            
            x++;
            
            if(x==99){
                for(int i = 0; i<10; i++){
                    equiposMixed[i]= equipos[i];
                }
            }
        }
        /*
        System.out.println(" ");
                System.out.println("---- Equipos mezclados ---- ");
                System.out.println("");
               for(int i=0; i<10; i++){
                    System.out.println(equiposMixed[i]);
                    
                }
        */        
    }
    
    //Metodo para crear el vs entre equipos
    public void fechas(){
        String aux;
        int auxPuntos;
        int auxPartGan;
        int auxPartEmp;
        int auxPartPerd;
        int auxgolesFavor;
        int auxgolesEncontra;
        int auxdif;
        
        for(int i=1; i<equiposMixed.length; i++){
            mostrarPartidos();
            resultados();
            
            aux = equiposMixed[1];
            auxPuntos = puntos[1];
            auxPartGan = partidosGanados[1];
            auxPartEmp = partidosEmpatados[1];
            auxPartPerd = partidosPerdidos[1];
            auxgolesFavor = golesFavor[1];
            auxgolesEncontra = golesEncontra[1];
            auxdif = diferenciaGoles[1];
            
            for(int j=1; j<equiposMixed.length-1; j++){
                equiposMixed[j] = equiposMixed[j+1];
                puntos[j] = puntos[j+1];
                partidosGanados[j] = partidosGanados[j+1];
                partidosEmpatados[j] = partidosEmpatados[j+1];
                partidosPerdidos[j] = partidosPerdidos[j+1];
                golesFavor[j] = golesFavor[j+1]; 
                golesEncontra[j] = golesEncontra[j+1];
                diferenciaGoles[j] = diferenciaGoles[j+1];
            }
            equiposMixed[equiposMixed.length-1] = aux;
            puntos[puntos.length-1] = auxPuntos;
            partidosGanados[partidosGanados.length-1] = auxPartGan;
            partidosEmpatados[partidosEmpatados.length-1] = auxPartEmp;
            partidosPerdidos[partidosPerdidos.length-1] = auxPartPerd;
            golesFavor[golesFavor.length-1] = auxgolesFavor;
            golesEncontra[golesEncontra.length-1] = auxgolesEncontra;
            diferenciaGoles[diferenciaGoles.length-1] = auxdif;
        }
        
        intercambio();
        
        for(int i=1; i<equiposMixed.length; i++){
            mostrarPartidos();
            resultados();
            
            aux = equiposMixed[1];
            auxPuntos = puntos[1];
            auxPartGan = partidosGanados[1];
            auxPartEmp = partidosEmpatados[1];
            auxPartPerd = partidosPerdidos[1];
            auxgolesFavor = golesFavor[1];
            auxgolesEncontra = golesEncontra[1];
            auxdif = diferenciaGoles[1];
            
            for(int j=1; j<equiposMixed.length-1; j++){
                equiposMixed[j] = equiposMixed[j+1];
                puntos[j] = puntos[j+1];
                partidosGanados[j] = partidosGanados[j+1];
                partidosEmpatados[j] = partidosEmpatados[j+1];
                partidosPerdidos[j] = partidosPerdidos[j+1];
                golesFavor[j] = golesFavor[j+1]; 
                golesEncontra[j] = golesEncontra[j+1];
                diferenciaGoles[j] = diferenciaGoles[j+1];
            }
            equiposMixed[equiposMixed.length-1] = aux;
            puntos[puntos.length-1] = auxPuntos;
            partidosGanados[partidosGanados.length-1] = auxPartGan;
            partidosEmpatados[partidosEmpatados.length-1] = auxPartEmp;
            partidosPerdidos[partidosPerdidos.length-1] = auxPartPerd;
            golesFavor[golesFavor.length-1] = auxgolesFavor;
            golesEncontra[golesEncontra.length-1] = auxgolesEncontra;
            diferenciaGoles[diferenciaGoles.length-1] = auxdif;
        }
        
    }
    
    //Muestro como quedo el sorteo Local - Visitante
    public void mostrarPartidos(){
        System.out.println("\n----------Fecha "+fecha+"----------");
        System.out.println("Local - Visitante");
        System.out.println("");
        for (int x = 0, j=equiposMixed.length-1; x<j; x++, j--) {
            System.out.println(equiposMixed[x]+" vs "+ equiposMixed[j]);
        }
        System.out.println();
        fecha++;
    }
    
    public void resultados(){
        System.out.println("----------Resultados----------");
        
        for(int i=0; i<5; i++){
            String equipoLocal = equiposMixed[i];       //0-1-2-3-4
            String equipoVisitante = equiposMixed[9-i]; //9-8-7-6-5
            
            //Guardo los puntajes de los equipos
            int puntosLocal=0;
            int puntosVisi=0;
            int partGanados=0;
            int empates=0;
            int partPerdidos=0;
            String ganador;
            
            //Guardo los goles de los equipos
            int golLocal = (int) (Math.random() * 6);
            int golVisi = (int) (Math.random() * 6);
            
            if(golLocal > golVisi){
                ganador = "[L]";
                puntosLocal = puntosLocal + 3;
                partGanados = partGanados + 1;
                partPerdidos = partPerdidos + 1;
                tablaLocales(equipoLocal, puntosLocal,partGanados, equipoVisitante, partPerdidos, golLocal, golVisi);
                
                
            }
            else 
                if(golVisi > golLocal){
                    ganador = "[V]";
                    puntosVisi = puntosVisi + 3;
                    partGanados = partGanados + 1;
                    partPerdidos = partPerdidos + 1;
                    tablaVisitantes(equipoVisitante, puntosVisi, partGanados, equipoLocal, partPerdidos, golVisi, golLocal);
            }
                else{
                    ganador = "[E]";
                    puntosLocal = puntosLocal + 1;
                    puntosVisi = puntosVisi + 1;
                    empates = empates + 1;
                    tablaEmpate(equipoVisitante, equipoLocal, puntosVisi, puntosLocal, empates, golLocal, golVisi);
                }
            
            System.out.println(equipoLocal+" "+golLocal+" "+ganador+" "+golVisi+" "+equipoVisitante+"");
            //System.out.println(equipoLocal+" suma "+puntosLocal+" puntos, "+equipoVisitante+" suma "+puntosVisi+" puntos." );
            //System.out.println("");
            
        }
    }
    
    public void tablaLocales(String equipoLocal, int puntosLocal, int partGanados, String equipoVisi, int partPerdidos, int golLocal, int golVisi){
        
        //int indice=0;
        //For para los Locales
        for(int i = 0; i < 10; i++){
            if(equiposMixed[i].equals(equipoLocal)){
                puntos[i] = puntos[i] + puntosLocal;
                partidosGanados[i] = partidosGanados[i] + partGanados;
                golesFavor[i] = golesFavor[i] + golLocal;
                golesEncontra[i] = golesEncontra[i] + golVisi;
                diferenciaGoles[i] = diferenciaGoles[i] +(golLocal - golVisi);
                //indice = i;
            }
            if(equiposMixed[i].equals(equipoVisi)){
                partidosPerdidos[i] = partidosPerdidos[i] + partPerdidos;
            }
        }
        //System.out.println(equipoLocal+" Tiene "+puntos[indice]);
        //System.out.println(equipoLocal+" Gano "+partidosGanados[indice]);
    }
    
    public void tablaVisitantes(String equipoVisi, int puntosVisi, int partGanados, String equipoLocal, int partPerdidos, int golVisi, int golLocal ){
        //int indice=0;
        //For para los Visitantes
        for(int i = 0; i < 10; i++){
            if(equiposMixed[i].equals(equipoVisi)){
                puntos[i] = puntos[i] + puntosVisi;
                partidosGanados[i] = partidosGanados[i] + partGanados;
                golesFavor[i] = golesFavor[i] + golVisi;
                golesEncontra[i] = golesEncontra[i] + golLocal;
                diferenciaGoles[i] = diferenciaGoles[i] +(golVisi - golLocal);
                //indice = i;
            }
            if(equiposMixed[i].equals(equipoLocal)){
                partidosPerdidos[i] = partidosPerdidos[i] + partPerdidos;
            }
        }
        //System.out.println(equipoVisi+" Tiene "+puntos[indice]);
        //System.out.println(equipoVisi+" Gano "+partidosGanados[indice]);
    }
    
    public void tablaEmpate(String equipoVisi, String equipoLocal, int puntosVisi, int puntosLocal, int empates, int golVisi, int golLocal){
        //int indice=0;
        //For para los Visitantes
        for(int i = 0; i < 10; i++){
            if(equiposMixed[i].equals(equipoVisi)){
                puntos[i] = puntos[i] + puntosVisi;
                partidosEmpatados[i] = partidosEmpatados[i] + empates;
                golesFavor[i] = golesFavor[i] + golVisi;
                golesEncontra[i] = golesEncontra[i] + golLocal;
                diferenciaGoles[i] = diferenciaGoles[i] + (golVisi - golLocal);
                //indice = i;
            }
        }
        //System.out.println(equipoVisi+" Tiene "+puntos[indice]);
        
        //int indice1=0;
        //For para los Locales
        for(int j = 0; j < 10; j++){
            if(equiposMixed[j].equals(equipoLocal)){
                puntos[j] = puntos[j] + puntosLocal;
                partidosEmpatados[j] = partidosEmpatados[j] + empates;
                golesFavor[j] = golesFavor[j] + golLocal;
                golesEncontra[j] = golesEncontra[j] + golVisi;
                diferenciaGoles[j] = diferenciaGoles[j] +(golLocal - golVisi);
                //indice1 = j;
            }
        }
        //System.out.println(equipoLocal+" Tiene "+puntos[indice1]);
        
    }
    
    public void intercambio(){
        for(int i=0; i < equiposMixed.length/2; i++){
            String aux = equiposMixed[i];
            equiposMixed[i] = equiposMixed[equiposMixed.length-1-i];
            equiposMixed[equiposMixed.length-1-i] = aux;
        }
    }    
    
    public void tabla(){
               System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
               System.out.printf("                                    TABLA DE POSICIONES%n");
               System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
               System.out.printf("|%13s|%13s|%13s|%13s|%13s|%13s|%13s|%13s|%n","EQUIPO","PUNTOS","PG","PE","PP","GF","GC","DG");
               System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
               int n1,n2,n3,n4,n5,n6,n7;
               String equipo;
               for(int i=0; i<10; i++){
                   equipo=equiposMixed[i];
                   n1=puntos[i];
                   n2=partidosGanados[i];
                   n3=partidosEmpatados[i];
                   n4=partidosPerdidos[i];
                   n5=golesFavor[i];
                   n6=golesEncontra[i];
                   n7=diferenciaGoles[i];
                  
                   System.out.printf("|%13s|%13d|%13d|%13d|%13d|%13d|%13d|%13d|%n", equipo,n1,n2,n3,n4,n5,n6,n7);
                   System.out.printf("-----------------------------------------------------------------------------------------------------------------%n");
               }
           }
    
    public void ordenarTabla(){
        String auxEquipo;
        int aux;
        
        for(int i=0; i<10; i++){
            for(int x=0; x<9 ; x++){
                if(puntos[x] < puntos[x+1]){
                    aux = puntos[x+1];
                    puntos[x+1] = puntos[x];
                    puntos[x] = aux;
                    auxEquipo = equiposMixed[x+1];
                    equiposMixed[x+1] = equipos[x];
                    equipos[x] = auxEquipo;
                    aux = partidosGanados[x+1];
                    partidosGanados[x+1] = partidosGanados[x];
                    partidosGanados[x] = aux;
                    aux = partidosEmpatados[x+1];
                    partidosEmpatados[x+1] = partidosEmpatados[x];
                    partidosEmpatados[x] = aux;
                    aux = partidosPerdidos[x+1];
                    partidosPerdidos[x+1] = partidosPerdidos[x];
                    partidosPerdidos[x] = aux;
                    aux = golesFavor[x+1];
                    golesFavor[x+1] = golesFavor[x];
                    golesFavor[x] = aux;
                    aux = golesEncontra[x+1];
                    golesEncontra[x+1] = golesEncontra[x];
                    golesEncontra[x] = aux;
                    aux = diferenciaGoles[x+1];
                    diferenciaGoles[x+1] = diferenciaGoles[x];
                    diferenciaGoles[x] = aux;
                }
            }
        }
        
        for(int j=0; j<10; j++){
            for(int i=0; i<9; i++){
                if(puntos[i] == puntos[i+1]){
                    if(diferenciaGoles[i] < diferenciaGoles[i+1]){
                        aux = diferenciaGoles[i+1];
                        diferenciaGoles[i+1] = diferenciaGoles[i];
                        diferenciaGoles[i] = aux;
                        aux = puntos[i+1];
                        puntos[i+1] = puntos[i];
                        puntos[i] = aux;
                        auxEquipo = equiposMixed[i+1];
                        equiposMixed[i+1] = equipos[i];
                        equipos[i] = auxEquipo;
                        aux = partidosGanados[i+1];
                        partidosGanados[i+1] = partidosGanados[i];
                        partidosGanados[i] = aux;
                        aux = partidosEmpatados[i+1];
                        partidosEmpatados[i+1] = partidosEmpatados[i];
                        partidosEmpatados[i] = aux;
                        aux = partidosPerdidos[i+1];
                        partidosPerdidos[i+1] = partidosPerdidos[i];
                        partidosPerdidos[i] = aux;
                        aux = golesFavor[i+1];
                        golesFavor[i+1] = golesFavor[i];
                        golesFavor[i] = aux;
                        aux = golesEncontra[i+1];
                        golesEncontra[i+1] = golesEncontra[i];
                        golesEncontra[i] = aux;
                    }
                }
            }
        }
        
        for(int i=0; i<10; i++){
            for(int j=0; j<9; j++){
                if((puntos[j] == puntos[j+1]) && (diferenciaGoles[j]==diferenciaGoles[j+1])){
                    if(golesFavor[j] < golesFavor[j+1]){
                        aux = golesFavor[j+1];
                        golesFavor[j+1] = golesFavor[j];
                        golesFavor[j] = aux;
                        aux = diferenciaGoles[j+1];
                        diferenciaGoles[j+1] = diferenciaGoles[j];
                        diferenciaGoles[j] = aux;
                        aux = puntos[j+1];
                        puntos[j+1] = puntos[j];
                        puntos[j] = aux;
                        auxEquipo = equiposMixed[j+1];
                        equiposMixed[j+1] = equipos[i];
                        equipos[j] = auxEquipo;
                        aux = partidosGanados[j+1];
                        partidosGanados[j+1] = partidosGanados[j];
                        partidosGanados[j] = aux;
                        aux = partidosEmpatados[j+1];
                        partidosEmpatados[j+1] = partidosEmpatados[j];
                        partidosEmpatados[j] = aux;
                        aux = partidosPerdidos[j+1];
                        partidosPerdidos[j+1] = partidosPerdidos[j];
                        partidosPerdidos[j] = aux;
                        aux = golesEncontra[j+1];
                        golesEncontra[j+1] = golesEncontra[j];
                        golesEncontra[j] = aux;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        CampeonatoAFA f1 = new CampeonatoAFA();
       
        f1.mezclar();
        f1.fechas();
        f1.ordenarTabla();
        System.out.println("");
        f1.tabla();
        
    }
}
