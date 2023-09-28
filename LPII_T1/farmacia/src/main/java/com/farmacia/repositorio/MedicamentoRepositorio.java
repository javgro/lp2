package com.farmacia.repositorio;

import java.util.List;

import com.farmacia.modelo.Medicamento;

public interface MedicamentoRepositorio {

	List<Medicamento> findAll();

	void deleteById(Integer id);

	Object findById(Integer id);

	void save(Medicamento medicamento);

}
