package com.marcelo.api_basica.Repository;

import com.marcelo.api_basica.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, String> {

}
