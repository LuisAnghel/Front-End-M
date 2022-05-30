package inter;
import simbolos.*;
public class For extends Instr {
    Expr expr; Instr instr, instr1, instr2;
    public For() { expr = null; instr = null; instr1 = null; instr2 = null;}
    public void inic(Instr s, Expr x, Instr s1, Instr s2){
        expr = x; instr = s; instr1 = s1; instr2 = s2;
        if(expr.tipo != Tipo.Bool) expr.error("se requiere booleano en For");
    }
    public void gen(int b, int a){
        despues = a;
        //para las instrucciones
        int etiqueta = nuevaEtiqueta(); int etiqueta2 = nuevaEtiqueta(); int etiqueta3 = nuevaEtiqueta();
        instr.gen(b, a); emitirEtiqueta(etiqueta);
        expr.salto(0, a); emitirEtiqueta(etiqueta2);
        instr2.gen(etiqueta, a); emitirEtiqueta(etiqueta3);
        instr1.gen(etiqueta2, a);
        emitir("goto L" + etiqueta);
    }
}