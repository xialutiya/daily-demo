package xilalu.test;

import java.util.ArrayList;
import java.util.List;

public class GlobalOne {

    /**
     * 柜身板面积.
     */
    private Double pureColor;
    /**
     * 柜身板总面积.
     */
    private Double totalPureColor;
    /**
     * 柜子投影面积.
     */
    private Double cabinet;
    /**
     * 是否存在指定门板造型.
     */
    private Boolean modeling;
    /**
     * 门板面积.
     */
    private Double doorPanel;
    /**
     * 检查结果.
     */
    private boolean checkResult;
    /**
     * 补贴结果说明.
     */
    private String resultDesc;
    /**
     * 纯色板面积.
     */
    private Double solidColor;
    /**
     * 是否需要继续执行.
     */
    private boolean process;
    /**
     * 判定结果系数.
     */
    private Double resultValue;
    /**
     * 门板面积/柜子投影面积是否等于0.
     */
    private boolean doorBool;
    /**
     * 门板面积/柜子投影面积是否小于0.2.
     */
    private boolean doorBoolTwo;
    /**
     * 纯色板面积/柜身板面积>20%.
     */
    private boolean solidBool;

    /**
     * 是否有柜身
     */
    private boolean hasCarcaseBody;

    /**
     * 柜身判断结果.
     */
    private boolean carcaseBodyResult;

    /**
     * 是否有柜门
     */
    private Boolean hasCabinetDoor;

    /**
     * 柜门判断结果.
     */
    private Boolean cabinetDoorResult;

    /**
     * 是否含有爱芯板
     *
     * @return
     */
    private boolean hasLoveCoreBoard;

    /**
     * 是否有敞门
     */
    private boolean hasOpenDoor;

    /**
     * 产品渠道.
     */
    private String productChannel;

    private List<String> lists;

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setCarcaseBodyResult(boolean carcaseBodyResult) {
        this.carcaseBodyResult = carcaseBodyResult;
    }

    public boolean getCarcaseBodyResult() {
        return carcaseBodyResult;
    }

    public Boolean getCabinetDoorResult() {
        return cabinetDoorResult;
    }

    public void setCabinetDoorResult(Boolean cabinetDoorResult) {
        this.cabinetDoorResult = cabinetDoorResult;
    }

    public String getProductChannel() {
        return productChannel;
    }

    public void setProductChannel(String productChannel) {
        this.productChannel = productChannel;
    }

    public Double getTotalPureColor() {
        return totalPureColor;
    }

    public void setTotalPureColor(Double totalPureColor) {
        this.totalPureColor = totalPureColor;
    }

    public boolean getHasOpenDoor() {
        return hasOpenDoor;
    }

    public void setHasOpenDoor(boolean hasOpenDoor) {
        this.hasOpenDoor = hasOpenDoor;
    }

    public boolean getHasLoveCoreBoard() {
        return hasLoveCoreBoard;
    }

    public void setHasLoveCoreBoard(boolean hasLoveCoreBoard) {
        this.hasLoveCoreBoard = hasLoveCoreBoard;
    }

    public boolean getHasCarcaseBody() {
        return hasCarcaseBody;
    }

    public void setHasCarcaseBody(boolean hasCarcaseBody) {
        this.hasCarcaseBody = hasCarcaseBody;
    }

    public boolean getHasCabinetDoor() {
        return hasCabinetDoor;
    }

    public void setHasCabinetDoor(boolean hasCabinetDoor) {
        this.hasCabinetDoor = hasCabinetDoor;
    }

    public boolean getDoorBoolTwo() {
        return doorBoolTwo;
    }

    public void setDoorBoolTwo(boolean doorBoolTwo) {
        this.doorBoolTwo = doorBoolTwo;
    }

    public Double getResultValue() {
        return resultValue;
    }

    public void setResultValue(Double resultValue) {
        this.resultValue = resultValue;
    }

    public GlobalOne() {

        this.pureColor = 0D;
        this.totalPureColor = 0D;
        this.cabinet = 0D;
        this.modeling = false;
        this.doorPanel = 0D;
        this.checkResult = false;
        this.resultDesc = "";
        this.solidColor = 0D;
        this.process = true;
        this.hasCabinetDoor = false;
        this.doorBool = false;
        this.solidBool = false;
        this.productChannel = "";
        this.cabinetDoorResult = false;
        this.carcaseBodyResult = false;
        this.lists = new ArrayList<>();
    }

    public boolean isDoorBool() {
        return doorBool;
    }

    public void setDoorBool(boolean doorBool) {
        this.doorBool = doorBool;
    }

    public boolean isSolidBool() {
        return solidBool;
    }

    public void setSolidBool(boolean solidBool) {
        this.solidBool = solidBool;
    }

    public Double getPureColor() {
        return pureColor;
    }

    public void setPureColor(Double pureColor) {
        this.pureColor = pureColor;
    }

    public Double getCabinet() {
        return cabinet;
    }

    public void setCabinet(Double cabinet) {
        this.cabinet = cabinet;
    }

    public Boolean getModeling() {
        return modeling;
    }

    public void setModeling(Boolean modeling) {
        this.modeling = modeling;
    }

    public Double getDoorPanel() {
        return doorPanel;
    }

    public void setDoorPanel(Double doorPanel) {
        this.doorPanel = doorPanel;
    }

    public boolean isCheckResult() {
        return checkResult;
    }

    public void setCheckResult(boolean checkResult) {
        this.checkResult = checkResult;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public Double getSolidColor() {
        return solidColor;
    }

    public void setSolidColor(Double solidColor) {
        this.solidColor = solidColor;
    }

    public boolean isProcess() {
        return process;
    }

    public void setProcess(boolean process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "GlobalOne{" +
                "pureColor=" + pureColor +
                ", totalPureColor=" + totalPureColor +
                ", cabinet=" + cabinet +
                ", modeling=" + modeling +
                ", doorPanel=" + doorPanel +
                ", checkResult=" + checkResult +
                ", resultDesc='" + resultDesc + '\'' +
                ", solidColor=" + solidColor +
                ", process=" + process +
                ", resultValue=" + resultValue +
                ", doorBool=" + doorBool +
                ", doorBoolTwo=" + doorBoolTwo +
                ", solidBool=" + solidBool +
                ", hasCarcaseBody=" + hasCarcaseBody +
                ", carcaseBodyResult=" + carcaseBodyResult +
                ", hasCabinetDoor=" + hasCabinetDoor +
                ", cabinetDoorResult=" + cabinetDoorResult +
                ", hasLoveCoreBoard=" + hasLoveCoreBoard +
                ", hasOpenDoor=" + hasOpenDoor +
                ", productChannel='" + productChannel + '\'' +
                ", lists=" + lists +
                '}';
    }
}
