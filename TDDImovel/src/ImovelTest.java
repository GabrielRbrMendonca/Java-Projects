import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
 * Demonstração de TDD em aula: imobiliária
 * Requisitos em comentário abaixo
 */
public class ImovelTest {
   
    /**
    * Uma imobiliária aluga casas e apartamentos.
        Cada imóvel tem um valor de venda  (ok)
        O aluguel deve ser entre 0.4% e 0.8% do valor de venda (ok)
        A comissão da imobiliária é de 12% (ok)
    */

    Imovel casa;

    @BeforeEach
    void init(){
        casa = new Imovel();
        casa.setValorVenda(100.0);
    }

    @Test
    @DisplayName ("Verifica se armazena o valor de venda.")
    void configurarValorDeVenda(){
        assertEquals(100.0, casa.precoVenda());
    }

    @Test
    void valorDoAluguel(){
        casa.setAluguel(0.05);
        assertEquals(5.0, casa.valorAluguel());

    }

    @Test
    void valorIncorretoDoAluguel(){
        casa.setAluguel(0.10);
        assertEquals(8.0, casa.valorAluguel());

    }

    @Test
    void valorComissao(){
        casa.setAluguel(0.10);
        assertEquals(0.96, casa.comissao());
    }




















}








