package servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test() throws Exception {

        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1",1,5.0);

        Locacao locacao = locacaoService.alugarFilme(usuario,filme);

        assertEquals(locacao.getValor(),5, 0.01);
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)));

        error.checkThat(locacao.getValor(),is(equalTo(5.0)));

        error.checkThat(DataUtils.isMesmaData(
                locacao.getDataLocacao(), new Date()), is(true));

        error.checkThat(DataUtils.isMesmaData(
                locacao.getDataRetorno(),DataUtils.obterDataComDiferencaDias(1)), is(true));

    }

    @Test(expected = Exception.class)
    public void testLocacao_filmeSemEstoque() throws Exception {
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1",0,5.0);

        locacaoService.alugarFilme(usuario,filme);
    }

    @Test
    public void testLocacao_filmeSemEstoque2() {
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1",0,5.0);

        try {
            locacaoService.alugarFilme(usuario,filme);
//            Assert.fail("deveria ter lançado uma excessão");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Filme sem estoque"));
//            throw new RuntimeException(e);
        }
    }

    @Test
    public void testLocacao_filmeSemEstoque3() throws Exception {
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1",0,5.0);
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Filme sem estoque");

        locacaoService.alugarFilme(usuario,filme);

    }

}
