<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fom" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="text-center w-screen h-auto mt-[30px] flex flex-col gap-3">
    <h1 class="text-2xl font-semibold">Tờ khai y tế</h1>
    <h3 class="font-medium">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3><p class="font-medium text-red-600">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam về xử lý hình sự</p>
</div>
<div class="w-screen flex justify-center items-center flex-col mt-[50px]">
    <form:form method="post" action="declare" modelAttribute="declareForm" cssClass="w-[90%]">
<%--        CUSTOMER--%>
        <div class="flex flex-col w-full gap-2">
            <form:label path="customer.name">Họ tên (ghi chữ IN HOA) <span class="text-red-600 text-black italic">(*)</span></form:label>
            <form:input path="customer.name" required="required" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-1 px-3"/>
        </div>

        <div class="flex justify-between gap-3 w-full mt-3">
            <div class="flex flex-col w-full gap-2">
                <form:label path="customer.year">Năm sinh <span class="text-red-600 text-black italic">(*)</span></form:label>
                <form:input path="customer.year" required="required" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3"/>
            </div>

            <div class="flex flex-col w-full gap-2">
                <form:label path="customer.gender">Giới tính <span class="text-red-600 text-black italic">(*)</span></form:label>
                <form:select path="customer.gender" required="required" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3">
                    <fom:option value="--Chọn--"/>
                    <fom:option value="Nam"/>
                    <fom:option value="Nữ"/>
                </form:select>
            </div>

            <div class="flex flex-col w-full gap-2">
                <form:label path="customer.national">Quốc tịch <span class="text-red-600 text-black italic">(*)</span></form:label>
                <form:input path="customer.national" required="required" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3"/>
            </div>
        </div>

        <div class="flex flex-col w-full gap-2 mt-3">
            <form:label path="customer.identityCard">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="text-red-600 text-black italic">(*)</span></form:label>
            <form:input path="customer.identityCard" required="required" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-1 px-3"/>
        </div>


        <%--        VEHICLE--%>
        <div class="flex flex-col justify-between gap-2 w-full mt-3">
            <p>Thông tin đi lại <span class="text-red-600 text-black italic">(*)</span></p>
            <div class="flex gap-3">
                <div class="flex gap-2">
                    <from:radiobutton path="vehicle.name" cssClass="" value="Tàu bay" />
                    <form:label path="vehicle.name">Tàu bay</form:label>
                </div>
                <div class="flex gap-2">
                    <from:radiobutton path="vehicle.name" cssClass="" value="Tàu thuyền" />
                    <form:label path="vehicle.name">Tàu thuyền</form:label>
                </div>
                <div class="flex gap-2">
                    <from:radiobutton path="vehicle.name" cssClass="" value="Ô tô" />
                    <form:label path="vehicle.name">Ô tô</form:label>
                </div>
                <div class="flex gap-2">
                    <from:radiobutton path="vehicle.name" cssClass="" value="Khác" />
                    <form:label path="vehicle.name">Khác (ghi rõ)</form:label>
                </div>
            </div>
        </div>

        <div class="flex justify-between gap-3 w-full mt-3">
            <div class="flex flex-col w-full gap-2">
                <form:label path="customer.year">Số hiệu phương tiện</form:label>
                <form:input path="vehicle.identityNumber" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3"/>
            </div>
            <div class="flex flex-col w-full gap-2">
                <form:label path="customer.year">Số ghế</form:label>
                <form:input path="vehicle.seat" cssClass="w-full border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3"/>
            </div>
        </div>

        <div class="flex justify-between gap-3 w-full mt-3">
            <div>
                <p>Ngày khởi hành<span class="text-red-600 text-black italic">(*)</span></p>
                <div class="flex gap-2 mt-2">
                    <form:input path="vehicle.startDate.date" required="required" cssClass="border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3 w-[39%]"/>
                    <form:input path="vehicle.startDate.month" required="required" cssClass="border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3 w-[39%]"/>
                    <form:input path="vehicle.startDate.year"  required="required" cssClass="border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3  w-[39%]"/>
                </div>
            </div>

            <div>
                <p>Ngày kết thúc<span class="text-red-600 text-black italic">(*)</span></p>
                <div class="flex gap-2 mt-2">
                    <form:input path="vehicle.endDate.date" required="required" cssClass="border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3 w-[39%]"/>
                    <form:input path="vehicle.endDate.month" required="required" cssClass="border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3 w-[39%]"/>
                    <form:input path="vehicle.endDate.year" required="required" cssClass="border-solid border-[1px] border-slate-300 shadow-md rounded p-0.5 px-3 w-[39%]"/>
                </div>
            </div>
        </div>

<%--        SYMPTOMS--%>
        <div class="w-full text-center mt-5 border-b-[1px] border-slate-300">
        <h1 class="text-md">Triệu chứng</h1>
        </div>
        <div class="w-full grid grid-cols-2 mt-3 border-b-[1px] border-slate-300 pb-3">
            <div class="w-full pr-5">
                <div class="flex justify-between">
                    <form:label path="symptoms.fever">Sốt <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.fever"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="symptoms.cough">Ho <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.cough"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="symptoms.shortnessBreath">Khó thở <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.shortnessBreath"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="symptoms.soreThroat">Đau họng <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.soreThroat"/>
                </div>
            </div>

            <div class="w-full pr-5">
                <div class="flex justify-between">
                    <form:label path="symptoms.vomiting_nausea">Nôn/ Buồn nôn <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.vomiting_nausea"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="symptoms.diarrhea">Tiêu chảy <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.diarrhea"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="symptoms.skinHemorrhage">Xuất huyết ngoài da <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.skinHemorrhage"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="symptoms.skinRash">Nổi ban ngoài da <span class="text-red-600 text-black italic">(*)</span></form:label>
                    <form:checkbox path="symptoms.skinRash"/>
                </div>
            </div>
        </div>

        <%--            HISTORY_INFECTION--%>
        <div class="flex flex-col mt-5 gap-2 w-full border-b-[1px] border-slate-300 border-solid pb-3">
            <div class="w-full text-center mb-2 pt-5 border-b-[1px] border-slate-300 border-solid">
                <p> Lịch sử phơi nhiễm: Trong vòng 14 ngày qua anh chị có <span class="text-red-600 text-black italic">(*)</span></p>
            </div>
            <div class="w-full flex flex-col gap-2">
                <div class="flex justify-between">
                    <form:label path="historyInfection.animalContact">Đến trang trại chăn nuôi/ Chợ buôn bán động vật sống/ Cơ sở giết mổ động vật/ tiếp xúc động vật</form:label>
                    <form:checkbox path="historyInfection.animalContact"/>
                </div>
                <div class="flex justify-between">
                    <form:label path="historyInfection.closeInfectedPerson">Tiếp xúc gần (<2m) với ngưới mắc bệnh đường hô hấp do nCoV</form:label>
                    <form:checkbox path="historyInfection.closeInfectedPerson"/>
                </div>
            </div>
        </div>

        <div class="mt-5 w-full flex justify-center items-center">
            <input  type="submit" value="Gửi tờ Khai" class="bg-green-600 text-white font-medium rounded-lg p-2">
        </div>
    </form:form>
</div>



</body>
</html>