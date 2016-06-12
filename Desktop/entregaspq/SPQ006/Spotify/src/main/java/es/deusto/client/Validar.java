
package es.deusto.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author iñigo
 */
public class Validar {
    
    boolean correcto = false;

    public Validar()
    {



    }

    // validamos la cadena email introducida en registro Usuario

    public boolean validarEmail(String _email)
    {
        boolean correctoemail= false;

        final String EXPRESION ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pemail = Pattern.compile(EXPRESION);
        Matcher ematch = pemail.matcher(_email);

        if(ematch.matches())
            correctoemail = true;
        else
            correctoemail = false;

        return correctoemail;


    }

    // validamos el nombre recibiendo una cadena de entrada
    // la expresión regular predefinida es la encargada de validarla
    public boolean validarNombre(String _nombre)
    {
        boolean correctonombre = false;
        String nombre ="^[a-zA-Z0-9]+$";

        Pattern pnombre = Pattern.compile(nombre);
        Matcher nmatch = pnombre.matcher(_nombre);

        if(nmatch.matches())
            correctonombre = true;
        else
            correctonombre = false;

        return correctonombre;

    }


    public boolean validarPassword(String _password)
    {

        boolean passwordcorrecta = false;

        String pass = "^[a-zA-Z0-9]+$";

        Pattern ppass= Pattern.compile(pass);
        Matcher pmatch = ppass.matcher(_password);

        if(pmatch.matches())
        {
            passwordcorrecta = true;
        }else
        {
            passwordcorrecta= false;
        }

        return  passwordcorrecta;
    }
    
}


