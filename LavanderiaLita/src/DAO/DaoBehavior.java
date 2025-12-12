package DAO;

import Entidade.Cliente;
import MyUtil.ManipulaArquivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kovalek
 */
public abstract class DaoBehavior <T, SearchKey>{
    
    protected List<T> listaObjetos = new ArrayList<T>();
    private ManipulaArquivo mp = new ManipulaArquivo();
    
    protected String savePath = "";
    
    
    //Control Status ==============
    public void initDao(){
        openSave();
    }
    public void closeDao(){
        closeSave();
    }
    //=============================
    
    
    
    // CRUD =======================================
    public abstract void create(T t);
    
    public abstract T retrive(SearchKey key);
    
    public void update(T tOld, T tNew){
        int index = listaObjetos.indexOf(tOld);
        listaObjetos.set(index, tNew);
    }
    
    public void delete(T t){
        listaObjetos.remove(t);
    }
    
    public List<String> listar(){
        List<String> ls = new ArrayList<String>();
        for(int i = 0; i < listaObjetos.size(); i++){
            ls.add(listaObjetos.get(i).toString());
        }
        return ls;
    }
    //===============================================
    
    
    // Load and Save ================================
    protected abstract T createObjectFromString(String str);
    
    private void openSave(){
        List<String> ls = mp.abrirArquivo(savePath);
        for(String s : ls){
            listaObjetos.add(createObjectFromString(s));
        }
    }
    
    private void closeSave(){
        mp.salvarArquivo(savePath, listar());
    }
    //================================================
}
