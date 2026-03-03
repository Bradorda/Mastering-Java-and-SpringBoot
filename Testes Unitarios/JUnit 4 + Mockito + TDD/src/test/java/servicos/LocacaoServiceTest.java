package servicos;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.LocacaoService;
import br.ce.wcaquino.utils.DataUtils;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LocacaoServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Test
    public void test() {

        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1",2,5.0);

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

}
