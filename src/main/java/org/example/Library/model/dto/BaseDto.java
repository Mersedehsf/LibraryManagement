package org.example.Library.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
    private Integer id;

    private Instant creationTime;

    private Instant updateAt;

    private boolean deleted;
}
