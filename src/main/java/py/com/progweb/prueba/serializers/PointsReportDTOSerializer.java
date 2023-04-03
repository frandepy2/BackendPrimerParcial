package py.com.progweb.prueba.serializers;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import py.com.progweb.prueba.dto.PointsReportDTO;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class PointsReportDTOSerializer extends JsonSerializer<PointsReportDTO> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void serialize(PointsReportDTO pointsReportDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("idCabecera", pointsReportDTO.getIdCabecera());
        jsonGenerator.writeObjectField("nombre", pointsReportDTO.getNombre());
        jsonGenerator.writeObjectField("apellido", pointsReportDTO.getApellido());
        jsonGenerator.writeStringField("fecha", dateFormat.format(pointsReportDTO.getFecha()));
        jsonGenerator.writeObjectField("puntajeUtilizado", pointsReportDTO.getPuntajeUtilizado());
        jsonGenerator.writeObjectField("puntajeUsado", pointsReportDTO.getPuntajeUsado());
        jsonGenerator.writeObjectField("concepto", pointsReportDTO.getConcepto());
        jsonGenerator.writeEndObject();
    }
}
