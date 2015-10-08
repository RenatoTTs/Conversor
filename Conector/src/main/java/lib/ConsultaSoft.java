package lib;

import java.util.List;

import server.ConectarMysql;

public class ConsultaSoft {
	ConectarMysql conectar = new ConectarMysql();
	
/**
 * Esse método tem a função de criar a sql para busca no banco softpharma.
 * @param modelo
 * @return
 */
	public List<ProdutosSoftpharma> pesquisaProdutosAtivos(TelaModelo modelo) {
		String sql = " SELECT  c.cad_descricao,  c.cad_cod_barra,  c1.cad_qtde_estoque	FROM  estcad1 AS c1  INNER JOIN estcad c ON c1.`cad_codigo` = c.`cad_codigo` WHERE c.`cad_situacao` = 0 ";		
		@SuppressWarnings("static-access")
		List<ProdutosSoftpharma> retornoPesquisa = conectar.pesquisaAtivos(sql,modelo.usuarioSoft, modelo.senhaSoft);
		
		return retornoPesquisa;
	}
	
	/**
	 * Esse método tem a função de validar a conexão.
	 * @param modelo
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Boolean validarConexao(TelaModelo modelo){
		
		if(conectar.conectarBanco(modelo.usuarioSoft, modelo.senhaSoft) != null){
			return true;
		}else{
			return false;
			
		}
		
	}

	
	
}