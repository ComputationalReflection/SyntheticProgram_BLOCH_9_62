package es.uniovi.reflection.bloch_9_62.compliant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Compliant {

    public void justOne() throws FileNotFoundException {
        new BufferedReader(new FileReader("file.txt"));
    }

    public void threeWithSubtype() throws FileNotFoundException, IOException, MalformedURLException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        br.readLine();
        new URL("spec");
    }
    public void threeWithSubtypeCatch() throws MalformedURLException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            br.readLine();
        }catch(IOException e){

        }
        new URL("spec");
    }

    public void threeReflectiveOp() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (toString().contains("M"))
            throw new ClassNotFoundException();
        this.getClass().newInstance();
    }

    public void threeReflectiveCatch() {
        try {
            if (toString().contains("M"))
                throw new ClassNotFoundException();
            this.getClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unchecked() {
        if (toString().contains("M"))
            throw new IllegalArgumentException();
        else
            throw new IllegalStateException();
    }

    public void mixed() throws ClassNotFoundException {
        if (toString().contains("M"))
            throw new ClassNotFoundException();
        else
            m();
        c();
    }

    private void c() throws ClassNotFoundException {
    }

    private void m() throws IllegalStateException {
    }

    public void goodCatch ()
            throws ReflectiveOperationException {
        try {
            if(toString().contains("M"))
                throw new ClassNotFoundException();

            this.getClass().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
    public void goodSign ()
            throws InstantiationException {
        try {
            if(toString().contains("M"))
                throw new ClassNotFoundException();

            this.getClass().newInstance();
        } catch (IllegalAccessException | ClassNotFoundException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
