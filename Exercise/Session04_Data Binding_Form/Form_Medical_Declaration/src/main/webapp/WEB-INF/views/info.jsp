<%--
  Created by IntelliJ IDEA.
  User: khoam
  Date: 2023-04-19
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Customer <br>
Name: ${declareForm.customer.name}<br>
Year: ${declareForm.customer.year}<br>
Gender: ${declareForm.customer.gender}<br>
Quốc tịch: ${declareForm.customer.national}<br>
CCCD: ${declareForm.customer.identityCard}<br>
----------------------------------------------------<br><br><br>

Vehicle<br>
Name: ${declareForm.vehicle.name}<br>
Identity Number: ${declareForm.vehicle.identityNumber}<br>
Seat: ${declareForm.vehicle.seat}<br>
Start Day: ${declareForm.vehicle.startDate.date} - ${declareForm.vehicle.startDate.month} -${declareForm.vehicle.startDate.year}<br>
End Day: ${declareForm.vehicle.endDate.date} - ${declareForm.vehicle.endDate.month} -${declareForm.vehicle.endDate.year}<br>
----------------------------------------------------<br><br><br>

Symptoms
${declareForm.symptoms.fever ? "Sốt" : ""}<br>
${declareForm.symptoms.cough ? "Ho" : ""}<br>
${declareForm.symptoms.shortnessBreath ? "Khó thở" : ""}<br>
${declareForm.symptoms.soreThroat ? "Đau họng" : ""}<br>
${declareForm.symptoms.vomiting_nausea ? "Nôn/Buồn nôn" : ""}<br>
${declareForm.symptoms.diarrhea ? "Tiêu chảy" : ""}<br>
${declareForm.symptoms.skinHemorrhage ? "Xuất huyết ngoài da" : ""}<br>
${declareForm.symptoms.skinRash ? "Phát ban ngoài da" : ""}<br>

----------------------------------------------------<br><br><br>
History Infection<br>
${declareForm.historyInfection.animalContact ? "Có đến trang trại chăn nuôi/ Chợ buôn bán động vật sống/ Cơ sở giết mổ động vật/ tiếp xúc động vật" : ""}<br>
${declareForm.historyInfection.closeInfectedPerson ? "Có tiếp xúc gần (<2m) với ngưới mắc bệnh đường hô hấp do nCoV" : ""}<br>


</body>
</html>
