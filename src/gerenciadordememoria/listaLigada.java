package gerenciadordememoria;

/**
 *
 * @author Ícaro
 */
public class listaLigada {

    // ENDEREÇO INICIAL DA LISTA
    private No inicio;

    // LISTA ESTÁ VAZIA
    public listaLigada() {
        this.inicio = null;
    }
//--------------------------------------------------------------- ADICIONAR ---------------------------------------------------------------------

    public No getInicio() {
        return inicio;
    }

    public void adicionaInicio(int elemento) {
        this.inicio = new No(elemento, this.inicio);
    }

    public void adicionaOrdenado(int x) {
        No aux = this.inicio;
        No ant = null;
        while (aux != null && aux.getElemento() < x) {
            ant = aux;
            aux = aux.getProx();
        }
        No novo = new No(x, aux);
        if (ant == null)// insere no inicio
        {
            this.inicio = novo;
        } else {
            ant.setProx(novo);
        }
    }

    public void adicionaFim(int x, int y) {
        No aux = this.inicio;
        No ant = null;
        while (aux != null) {
            ant = aux;
            aux = aux.getProx();
        }
        No novo = new No(x, null);

        // INSERE NO INÍCIO
        if (ant == null) {
            this.inicio = novo;
        } else {
            ant.setProx(novo);
        }
    }

//----------------------------------------------------------------- REMOVER ---------------------------------------------------------------------
    public int removeInicio() {
        // ANTES DE REMOVER VERIFICAMOS SE TEMOS UM NÓ NA LISTA

        // SE A LISTA NÃO ESTIVER VAZIA
        if (!this.estaVazio()) {

            // GUARDA A CÉLULA QUE SERÁ REMOVIDA
            No ant = this.inicio;

            // avançar a referência que aponta para o primeiro Nó (inicio)
            // para o próximo Nó da lista
            this.inicio = this.inicio.getProx();

            return ant.getElemento();

        } else {

            throw new RuntimeException("Lista vazia!");
        }

    }

//---------------------------------------------------------- VERIFICAR SE ESTÁ VAZIO ------------------------------------------------------------
    public boolean estaVazio() {
        return this.inicio == null;
    }

    @Override
    public String toString() {
        return this.inicio + "";
    }

//----------------------------------------------------------------- BUSCAS ----------------------------------------------------------------------
    private boolean busca(int x, No aux) {
        // CONDIÇÕES DE PARADA
        if (aux == null) {
            return false;
        }
        if (aux.getElemento() == x) {
            return true;
        }
        return busca(x, aux.getProx());
    }

    // BUSCA ITERATIVA
    public boolean busca(int x) {

        for (No aux = this.inicio; aux != null; aux = aux.getProx()) {
            if (aux.getElemento() == x) {
                return true;
            }
        }
        return false;
    }

    // BUSCA RECURSIVA
    public boolean buscaRecursiva(int x) {
        return busca(x, this.inicio);
    }
}
