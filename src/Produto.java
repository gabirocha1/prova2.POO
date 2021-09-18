import java.time.LocalDate;

public class Produto {
    public int cOdigo;
    public String nOme;
    private Double vAlor;
    public int qTdEstoque;
    public int cOdDigitado;
    public int qTdDigitada;
    public LocalDate dAta;
    public LocalDate dAtaI;
    public LocalDate dAtaF;
    public Double tOtal;
    
    
    
    public Produto(String nome, int codigo, Double valor, int qtdEstoque) {
        this.nOme = nome;
        this.cOdigo = codigo;
        this.vAlor = valor;
        this.qTdEstoque = qtdEstoque;

    }

    public int getCodigo() {
        return cOdigo;
    }
    public void setCodigo(int codigo) {
        this.cOdigo = codigo;
    }
    public String getNome() {
        return nOme;
    }
    public void setNome(String nome) {
        this.nOme = nome;
    }
    public double getValor() {
        return vAlor;
    }
    public void setValor(Double valor) {
        this.vAlor = valor;
    }
    public int getQtdEstoque() {
        return qTdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qTdEstoque = qtdEstoque;
    }
    public LocalDate getData() {
        return dAta;
    }
    public void setData(LocalDate data) {
        this.dAta = data;}

    public int getCodDigitado() {
        return cOdDigitado;
        }
    public void setcodDigitado(int codDigitado) {
        this.cOdDigitado = codDigitado;}

    public int getQtdDigitada() {
        return qTdDigitada;
            }
    public void setQtdDigitada(int qtdDigitada) {
        this.qTdDigitada = qtdDigitada;}

    public Double getTotal() {
        return tOtal;
                }
    public void setTotal(Double total) {
        this.tOtal = total;}

        public LocalDate getDAtaI() {
            return dAtaI;
        }
        public void setDAtaI(LocalDate dataI) {
            this.dAtaI = dataI;}  
            
            public LocalDate getDAtaF() {
                return dAtaF;
            }
            public void setDAtaF(LocalDate dataF) {
                this.dAtaF = dataF;}    
                
}
