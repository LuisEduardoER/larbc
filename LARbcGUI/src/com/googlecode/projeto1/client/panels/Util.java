package com.googlecode.projeto1.client.panels;

import com.google.gwt.user.client.ui.Image;

/**
 * @author Alcione Pinheiro
 * @author Diego Rodrigues
 * @author João Felipe
 * @version LARbc 1.0
 */
public class Util {
	
	public final static String AJUDA_BUTTON_IMAGE = "images/ajudaButton.png";
	public final static String AJUDA_SELECTED_BUTTON_IMAGE = "images/ajudaSelectedButton.png";
	public final static String VOLTAR_BUTTON_IMAGE = "images/botaoVoltar.png";
	public final static String VOLTAR_SELECTED_BUTTON_IMAGE = "images/voltarSelected.png";
	public final static String LARBC_IMAGE_PATH = "images/larbc.png";
	public final static String CADASTRAR_BUTTON_IMAGE = "images/cadastrar.PNG";
	public final static String SELECTED_CADASTRAR_BUTTON_IMAGE = "images/cadastrarSelected.PNG";
	public final static String PESQUISAR_BUTTON_IMAGE = "images/pesquisar.PNG";
	public final static String PESQUISAR_SELECTED_BUTTON_IMAGE = "images/pesquisarSelected.PNG";
	public final static String ENTRAR_BUTTON_IMAGE = "images/ENTRAR.PNG";
	public final static String ENTRAR_SELECTED_BUTTON_IMAGE = "images/entrarSelected.PNG";
	public final static String FAMILY_IMAGE_PATH= "images/familia.png";
	public final static String SOUTO_MAIOR_IMAGE_PATH = "images/soutoMaior.png";
	public final static String PREENCHIMENTO_PATH = "images/preenchimento.png";
	public final static String ADMINISTRAR_BUTTON_IMAGE = "images/botaoAdministrar.PNG";
	public final static String SELECTED_ADMINISTRAR_BUTTON_IMAGE = "images/botaoAdministrarSelecionado.PNG";
	public final static String QUESTION = "images/questao.PNG";
	public final static String VENDER_BUTTON_IMAGE = "images/venderButton.PNG";
	public final static String ALUGAR_BUTTON_IMAGE = "images/alugarButton.PNG";
	public final static String COMPRAR_BUTTON_IMAGE = "images/comprarButton.PNG";
	public final static String SELECTED_VENDER_BUTTON_IMAGE = "images/selectedVenderButton.PNG";
	public final static String SELECTED_ALUGAR_BUTTON_IMAGE = "images/selectedAlugarButton.PNG";
	public final static String SELECTED_COMPRAR_BUTTON_IMAGE = "images/selectedComprarButton.PNG";
	public final static String IMMOBILE_IMAGE_PATH = "images/imoveisEncontrados.PNG";
	public final static String COMMERCIAL_IMMOBILE_PATH = "images/estabelecimentoComercial.PNG";
	public final static String RESIDENTIAL_IMMOBILE_PATH = "images/estabelecimentoResidencial.PNG";
	public final static String ESCOLA_PATH = "images/escola.png";
	
	public static Image createImage(String path){
		Image image = new Image(path);
		image.setSize("auto", "auto");
		return image;
	}
	
	public static Image createImage(String path, int size){
		Image image = new Image(path);
		String sizePx = size + "px";
		image.setSize(sizePx, sizePx);
		return image;
	}

}
