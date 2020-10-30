package archaleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        //Escritura del fichero
        RandomAccessFile f = new RandomAccessFile("texto1.txt","rw");
        String[] codes = {"p1","p2","p3"};
        String[] descs = {"parafusos","cravos ","tachas"};
        String aux=null;
        int[] precios = { 3,4,5 };

        for(int i=0;i<3;i++){
            aux=String.format("%-" + 3 + "s", codes[i]);
            aux=aux.replace(' ','0');
            f.writeChars(aux);
            aux=String.format("%-" + 10 + "s", descs[i]);
            aux=aux.replace(' ','0');
            f.writeChars(aux);
            f.writeInt(precios[i]);
        }
        /*es una prueba de como funciona el seek()
        f.seek(2);
        System.out.println(f.readChar());*/

        //Lectura del fichero

        char in;
        String cod="";
        String desc="";
        int precio;
        /*Product[] prod=new Product[3];
        f.seek(0);
        
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++) {
                in=f.readChar();
                cod=cod+in;
            }
            cod=cod.replace("0","");
            for(int i=0;i<10;i++) {
                in=f.readChar();
                desc=desc+in;
            }
            desc=desc.replaceAll("0","");
            precio=f.readInt();
            prod[j]=new Product(cod,desc,precio);
            cod= desc ="";
        }
        for(int i=0;i<3;i++){
            System.out.println(prod[i]);
        }
        //System.out.println(f.length
        */
        f.seek((2-1)*30);
        for(int i=0;i<3;i++){
            in=f.readChar();
            cod=cod+in;
        }
        for(int i=0;i<10;i++){
            in=f.readChar();
            desc=desc+in;
        }
        cod=cod.replaceAll("0", "");
        desc=desc.replaceAll("0", "");
        System.out.println(cod);
        System.out.println(desc);
        System.out.println(f.readInt());
        f.close();
    }
}
