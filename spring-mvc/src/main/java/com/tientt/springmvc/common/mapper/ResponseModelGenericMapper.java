package com.tientt.springmvc.common.mapper;

import java.util.List;

public interface ResponseModelGenericMapper<S, D> {
    D toResponseModel(S dto);

    S toDTO(D responseModel);

    List<D> toResponseModel(List<S> responseModel);

    List<S> toDTO(List<D> dtos);
}
