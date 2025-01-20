package com.appstra.employee.methods;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Functions {
    /**
     * Metodo para organizar el body de respuesta del reporte de documentos persona.
     * @param originalData
     * @return List<Map<String, Object>> reorganizedData
     */
    public List<Map<String,Object>> bodyOrganizerGetReportDocuments(List<Map<String,Object>> originalData){
        List<Map<String, Object>> reorganizedData = new ArrayList<>();

        for (Map<String, Object> entry : originalData) {
            Map<String, Object> reorganizedEntry = new LinkedHashMap<>();

            reorganizedEntry.put("personId", entry.get("personId"));
            reorganizedEntry.put("employeeId", entry.get("employeeId"));
            reorganizedEntry.put("personIdentificationNumber", entry.get("personIdentificationNumber"));
            reorganizedEntry.put("personName", entry.get("personName"));
            reorganizedEntry.put("companyId", entry.get("companyId"));
            reorganizedEntry.put("companyName", entry.get("companyName"));
            reorganizedEntry.put("roleId", entry.get("roleId"));
            reorganizedEntry.put("cargados", entry.get("cargados"));
            reorganizedEntry.put("requeridos", entry.get("requeridos"));

            reorganizedData.add(reorganizedEntry);
        }

        return reorganizedData;
    }

    public List<Map<String,Object>> bodyOrganizerGetReportDocumentsEmployee(List<Map<String,Object>> originalData){
        List<Map<String, Object>> reorganizedData = new ArrayList<>();

        for (Map<String, Object> entry : originalData) {
            Map<String, Object> reorganizedEntry = new LinkedHashMap<>();

            reorganizedEntry.put("personId", entry.get("personId"));
            reorganizedEntry.put("personName", entry.get("personName"));
            reorganizedEntry.put("personIdentificationNumber", entry.get("personIdentificationNumber"));
            reorganizedEntry.put("employeeId", entry.get("employeeId"));
            reorganizedEntry.put("documentGroupId", entry.get("documentGroupId"));
            reorganizedEntry.put("documentGroupName", entry.get("documentGroupName"));
            reorganizedEntry.put("roleId", entry.get("roleId"));
            reorganizedEntry.put("typeDocumentId", entry.get("typeDocumentId"));
            reorganizedEntry.put("typeDocumentName", entry.get("typeDocumentName"));
            reorganizedEntry.put("state", entry.get("state"));

            reorganizedData.add(reorganizedEntry);
        }

        return reorganizedData;
    }
}
