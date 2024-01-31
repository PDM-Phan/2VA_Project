package Util;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Validator extends PlainDocument {
    private final int limite;

    public Validator(int limite) {
        this.limite = limite;
    }
    
    @Override
    public void insertString(int ofs, String str, AttributeSet a) throws BadLocationException{
        if (this.getLength() + str.length() <= this.limite){ // verifica se o que esta sendo digitado na area de texto é menor ou igual ao limite
            super.insertString(ofs, str, a); // vai inserir na caixa de texto
        }
    }
}
