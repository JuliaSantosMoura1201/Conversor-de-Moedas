package com.julia.conversordemoedas.helper;

import com.julia.conversordemoedas.model.Item;

import java.util.List;

public interface IConversaoDAO {

    public boolean salvar(Item item);

    public boolean deletar(Item item);

    public List<Item> listar(int flag);
}
