package pecas;

import enums.enumCorPeca;
import pecas.impl.PecaAbstract;
import pontos.IPonto;

public class PecaFactory {
    public static PecaAbstract criaPeca(Class<?> dataType, enumCorPeca cor, IPonto local){
        try {
            Class pecaTipo = Class.forName(dataType.getName());
            PecaAbstract peca = (PecaAbstract) pecaTipo.getConstructor().newInstance();
            peca.setCor(cor);
            peca.setLocalizacao(local.getLinha(),local.getColuna());
            return peca;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
}
