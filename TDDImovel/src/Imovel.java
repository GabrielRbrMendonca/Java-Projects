/** 
 * MIT License
 *
 * Copyright(c) 2022 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

 /**
  * Classe Imovel para demonstração do TDD em aula.
  */
public class Imovel {
    private static final double MIN_ALUGUEL=0.4;
    private static final double MAX_ALUGUEL=0.8;
    private double aluguel;
    private double valorVenda;

    /**
     * Determina o valor de venda do imóvel
     * @param valor Valor absoluto para venda.
     */
    public void setValorVenda(double valor) {
        this.valorVenda = valor;
    }

    /**
     * Retorna o valor de venda do imóvel
     * @return Double com o valor de venda.
     */
    public double precoVenda() {
        return this.valorVenda;
    }

    /**
     * Determina a alíquota para valor do aluguel do imóvel.
     * Alíquotas abaixo do mínimo ou acima do máximo reverterão, respectivamente, para mínimo e máximo.
     * @param aliquota Alíquota para o valor do aluguel, em porcentagem: de 0.04 a 0.08
     */
    public void setAluguel(double aliquota) {
        this.aluguel = aliquota;
        if(aliquota<MIN_ALUGUEL)
            this.aluguel = MIN_ALUGUEL;
        else
            if(aliquota>MAX_ALUGUEL)
            this.aluguel = MAX_ALUGUEL;
    }

    /**
     * Calcula e retorna o valor do aluguel baseado em preço de venda e aliquota
     * @return Double com valor do aluguel
     */
    public double valorAluguel() {
        return this.aluguel*this.precoVenda();
    }

    /**
     * Calcula e retorna a comissão da imobiliária sobre o aluguel.
     * @return Double com o valor da comissão a receber
     */
    public double comissao() {
        return 0.12 * valorAluguel();
    }
    
}
