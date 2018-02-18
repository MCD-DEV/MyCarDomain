package au.com.pnspvtltd.mcd.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templatespecification")
public class SpecificationTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long templateSpecificationId;
	private String colorName1;
	private String colorName2;
	private String colorName3;
	private String colorName4;
	private String colorName5;
	private String makeCountry;
	private String modelBody;
	private String modelEnginePosition;
	private String modelEngineType;
	private int modelEngineCyl;
	private int modelEnginecc;
	private double modelEnginel;
	private int modelEngineci;
	private double modelEngineBoremm;
	private double modelEngineBorein;
	private double modelEngineStrokemm;
	private double modelEngineStrokein;
	private int modelEngineValvespercyl;
	private int modelEngineValves;
	private int modelEnginePowerhp;
	private int modelEnginePowerps;
	private int modelEnginePowerkw;
	private int modelEnginePowerrpm;
	private int modelEngineTorquenm;
	private int modelEngineTorquelbft;
	private int modelEngineTorquekgm;
	private int modelEngineTorquerpm;
	private double modelEngineCompression;
	private String modelEngineFuel;
	private String modelDrive;
	private String modelTransmissionType;
	private int modelTopSpeedkph;
	private int modelTopSpeedmph;
	private double model0to100kph;
	private int modelDoors;
	private int modelSeats;
	private int modelWeightkg;
	private int modelWeightlbs;
	private int modelLengthmm;
	private double modelLengthin;
	private double modelWidthmm;
	private double modelWidthin;
	private double modelHeightmm;
	private double modelHeightin;
	private double modelWheelbasemm;
	private double modelWheelbasein;
	private double modellkmCity;
	private double modelmpgCity;
	private double modellkmhwy;
	private double modelmpghwy;
	private double modellkmMixed;
	private double modelmpgMixed;
	private double modelFuelcapl;
	private double modelFuelcapg;

	@Column(name = "MAKECOUNTRY")
	public String getMakeCountry() {
		return makeCountry;
	}

	public void setMakeCountry(String makeCountry) {
		this.makeCountry = makeCountry;
	}

	@Column(name = "MODELBODY")
	public String getModelBody() {
		return modelBody;
	}

	public void setModelBody(String modelBody) {
		this.modelBody = modelBody;
	}

	@Column(name = "MODELENGINEPOSITION")
	public String getModelEnginePosition() {
		return modelEnginePosition;
	}

	public void setModelEnginePosition(String modelEnginePosition) {
		this.modelEnginePosition = modelEnginePosition;
	}

	@Column(name = "MODELENGINETYPE")
	public String getModelEngineType() {
		return modelEngineType;
	}

	public void setModelEngineType(String modelEngineType) {
		this.modelEngineType = modelEngineType;
	}

	@Column(name = "MODELENGINECYL")
	public int getModelEngineCyl() {
		return modelEngineCyl;
	}

	public void setModelEngineCyl(int modelEngineCyl) {
		this.modelEngineCyl = modelEngineCyl;
	}

	@Column(name = "MODELENGINECC")
	public int getModelEnginecc() {
		return modelEnginecc;
	}

	public void setModelEnginecc(int modelEnginecc) {
		this.modelEnginecc = modelEnginecc;
	}

	@Column(name = "MODELENGINEL")
	public double getModelEnginel() {
		return modelEnginel;
	}

	public void setModelEnginel(double modelEnginel) {
		this.modelEnginel = modelEnginel;
	}

	@Column(name = "MODELENGINECI")
	public int getModelEngineci() {
		return modelEngineci;
	}

	public void setModelEngineci(int modelEngineci) {
		this.modelEngineci = modelEngineci;
	}

	@Column(name = "MODELENGINEBOREMM")
	public double getModelEngineBoremm() {
		return modelEngineBoremm;
	}

	public void setModelEngineBoremm(double modelEngineBoremm) {
		this.modelEngineBoremm = modelEngineBoremm;
	}

	@Column(name = "MODELENGINEBOREIN")
	public double getModelEngineBorein() {
		return modelEngineBorein;
	}

	public void setModelEngineBorein(double modelEngineBorein) {
		this.modelEngineBorein = modelEngineBorein;
	}

	@Column(name = "MODELENGINESTROKEMM")
	public double getModelEngineStrokemm() {
		return modelEngineStrokemm;
	}

	public void setModelEngineStrokemm(double modelEngineStrokemm) {
		this.modelEngineStrokemm = modelEngineStrokemm;
	}

	@Column(name = "MODELENGINESTROKEIN")
	public double getModelEngineStrokein() {
		return modelEngineStrokein;
	}

	public void setModelEngineStrokein(double modelEngineStrokein) {
		this.modelEngineStrokein = modelEngineStrokein;
	}

	@Column(name = "MODELENGINEVALVESPERCYL")
	public int getModelEngineValvespercyl() {
		return modelEngineValvespercyl;
	}

	public void setModelEngineValvespercyl(int modelEngineValvespercyl) {
		this.modelEngineValvespercyl = modelEngineValvespercyl;
	}

	@Column(name = "MODELENGINEVALVES")
	public int getModelEngineValves() {
		return modelEngineValves;
	}

	public void setModelEngineValves(int modelEngineValves) {
		this.modelEngineValves = modelEngineValves;
	}

	@Column(name = "MODELENGINEPOWERHP")
	public int getModelEnginePowerhp() {
		return modelEnginePowerhp;
	}

	public void setModelEnginePowerhp(int modelEnginePowerhp) {
		this.modelEnginePowerhp = modelEnginePowerhp;
	}

	@Column(name = "MODELENGINEPOWERPS")
	public int getModelEnginePowerps() {
		return modelEnginePowerps;
	}

	public void setModelEnginePowerps(int modelEnginePowerps) {
		this.modelEnginePowerps = modelEnginePowerps;
	}

	@Column(name = "MODELENGINEPOWERKW")
	public int getModelEnginePowerkw() {
		return modelEnginePowerkw;
	}

	public void setModelEnginePowerkw(int modelEnginePowerkw) {
		this.modelEnginePowerkw = modelEnginePowerkw;
	}

	@Column(name = "MODELENGINEPOWERRPM")
	public int getModelEnginePowerrpm() {
		return modelEnginePowerrpm;
	}

	public void setModelEnginePowerrpm(int modelEnginePowerrpm) {
		this.modelEnginePowerrpm = modelEnginePowerrpm;
	}

	@Column(name = "GETMODELENGINETORQUENM")
	public int getModelEngineTorquenm() {
		return modelEngineTorquenm;
	}

	public void setModelEngineTorquenm(int modelEngineTorquenm) {
		this.modelEngineTorquenm = modelEngineTorquenm;
	}

	@Column(name = "MODELENGINETORQUELBFT")
	public int getModelEngineTorquelbft() {
		return modelEngineTorquelbft;
	}

	public void setModelEngineTorquelbft(int modelEngineTorquelbft) {
		this.modelEngineTorquelbft = modelEngineTorquelbft;
	}

	@Column(name = "MODELENGINETORQUEKGM")
	public int getModelEngineTorquekgm() {
		return modelEngineTorquekgm;
	}

	public void setModelEngineTorquekgm(int modelEngineTorquekgm) {
		this.modelEngineTorquekgm = modelEngineTorquekgm;
	}

	@Column(name = "MODELENGINETORQUERPM")
	public int getModelEngineTorquerpm() {
		return modelEngineTorquerpm;
	}

	public void setModelEngineTorquerpm(int modelEngineTorquerpm) {
		this.modelEngineTorquerpm = modelEngineTorquerpm;
	}

	@Column(name = "MODELENGINECOMPRESSION")
	public double getModelEngineCompression() {
		return modelEngineCompression;
	}

	public void setModelEngineCompression(double modelEngineCompression) {
		this.modelEngineCompression = modelEngineCompression;
	}

	@Column(name = "MODELENGINEFUEL")
	public String getModelEngineFuel() {
		return modelEngineFuel;
	}

	public void setModelEngineFuel(String modelEngineFuel) {
		this.modelEngineFuel = modelEngineFuel;
	}

	@Column(name = "MODELDRIVE")
	public String getModelDrive() {
		return modelDrive;
	}

	public void setModelDrive(String modelDrive) {
		this.modelDrive = modelDrive;
	}

	@Column(name = "MODELTRANSMISSIONTYPE")
	public String getModelTransmissionType() {
		return modelTransmissionType;
	}

	public void setModelTransmissionType(String modelTransmissionType) {
		this.modelTransmissionType = modelTransmissionType;
	}

	@Column(name = "MODELTOPSPEEDKPH")
	public int getModelTopSpeedkph() {
		return modelTopSpeedkph;
	}

	public void setModelTopSpeedkph(int modelTopSpeedkph) {
		this.modelTopSpeedkph = modelTopSpeedkph;
	}

	@Column(name = "MODELTOPSPEEDMPH")
	public int getModelTopSpeedmph() {
		return modelTopSpeedmph;
	}

	public void setModelTopSpeedmph(int modelTopSpeedmph) {
		this.modelTopSpeedmph = modelTopSpeedmph;
	}

	@Column(name = "MODEL0TO100KPH")
	public double getModel0to100kph() {
		return model0to100kph;
	}

	public void setModel0to100kph(double model0to100kph) {
		this.model0to100kph = model0to100kph;
	}

	@Column(name = "MODELDOORS")
	public int getModelDoors() {
		return modelDoors;
	}

	public void setModelDoors(int modelDoors) {
		this.modelDoors = modelDoors;
	}

	@Column(name = "MODELSEATS")
	public int getModelSeats() {
		return modelSeats;
	}

	public void setModelSeats(int modelSeats) {
		this.modelSeats = modelSeats;
	}

	@Column(name = "MODELWEIGHTKG")
	public int getModelWeightkg() {
		return modelWeightkg;
	}

	public void setModelWeightkg(int modelWeightkg) {
		this.modelWeightkg = modelWeightkg;
	}

	@Column(name = "MODELWEIGHTLBS")
	public int getModelWeightlbs() {
		return modelWeightlbs;
	}

	public void setModelWeightlbs(int modelWeightlbs) {
		this.modelWeightlbs = modelWeightlbs;
	}

	@Column(name = "MODELLENGTHMM")
	public int getModelLengthmm() {
		return modelLengthmm;
	}

	public void setModelLengthmm(int modelLengthmm) {
		this.modelLengthmm = modelLengthmm;
	}

	@Column(name = "MODELLENGTHIN")
	public double getModelLengthin() {
		return modelLengthin;
	}

	public void setModelLengthin(double modelLengthin) {
		this.modelLengthin = modelLengthin;
	}

	@Column(name = "MODELWIDTHMM")
	public double getModelWidthmm() {
		return modelWidthmm;
	}

	public void setModelWidthmm(double modelWidthmm) {
		this.modelWidthmm = modelWidthmm;
	}

	@Column(name = "MODELWIDTHIN")
	public double getModelWidthin() {
		return modelWidthin;
	}

	public void setModelWidthin(double modelWidthin) {
		this.modelWidthin = modelWidthin;
	}

	@Column(name = "MODELHEIGHTMM")
	public double getModelHeightmm() {
		return modelHeightmm;
	}

	public void setModelHeightmm(double modelHeightmm) {
		this.modelHeightmm = modelHeightmm;
	}

	@Column(name = "MODELHEIGHTIN")
	public double getModelHeightin() {
		return modelHeightin;
	}

	public void setModelHeightin(double modelHeightin) {
		this.modelHeightin = modelHeightin;
	}

	@Column(name = "MODELWHEELBASE")
	public double getModelWheelbasemm() {
		return modelWheelbasemm;
	}

	public void setModelWheelbasemm(double modelWheelbasemm) {
		this.modelWheelbasemm = modelWheelbasemm;
	}

	@Column(name = "MODELWHEELBASEIN")
	public double getModelWheelbasein() {
		return modelWheelbasein;
	}

	public void setModelWheelbasein(double modelWheelbasein) {
		this.modelWheelbasein = modelWheelbasein;
	}

	@Column(name = "MODELLKMCITY")
	public double getModellkmCity() {
		return modellkmCity;
	}

	public void setModellkmCity(double modellkmCity) {
		this.modellkmCity = modellkmCity;
	}

	@Column(name = "MODELMPGCITY")
	public double getModelmpgCity() {
		return modelmpgCity;
	}

	public void setModelmpgCity(double modelmpgCity) {
		this.modelmpgCity = modelmpgCity;
	}

	@Column(name = "MODELLKMWHY")
	public double getModellkmhwy() {
		return modellkmhwy;
	}

	public void setModellkmhwy(double modellkmhwy) {
		this.modellkmhwy = modellkmhwy;
	}

	@Column(name = "MODELMPGHWY")
	public double getModelmpghwy() {
		return modelmpghwy;
	}

	public void setModelmpghwy(double modelmpghwy) {
		this.modelmpghwy = modelmpghwy;
	}

	@Column(name = "MODELLKMMIXED")
	public double getModellkmMixed() {
		return modellkmMixed;
	}

	public void setModellkmMixed(double modellkmMixed) {
		this.modellkmMixed = modellkmMixed;
	}

	@Column(name = "MODELMPGMIXED")
	public double getModelmpgMixed() {
		return modelmpgMixed;
	}

	public void setModelmpgMixed(double modelmpgMixed) {
		this.modelmpgMixed = modelmpgMixed;
	}

	@Column(name = "MODELFUELCAPL")
	public double getModelFuelcapl() {
		return modelFuelcapl;
	}

	public void setModelFuelcapl(double modelFuelcapl) {
		this.modelFuelcapl = modelFuelcapl;
	}

	@Column(name = "MODELFUELCAPG")
	public double getModelFuelcapg() {
		return modelFuelcapg;
	}

	public void setModelFuelcapg(double modelFuelcapg) {
		this.modelFuelcapg = modelFuelcapg;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEMPLATESPECIFICATIONID")
	public Long getTemplateSpecificationId() {
		return this.templateSpecificationId;
	}

	public void setTemplateSpecificationId(Long templateSpecificationId) {
		this.templateSpecificationId = templateSpecificationId;
	}

	public String getColorName1() {
		return colorName1;
	}

	public void setColorName1(String colorName1) {
		this.colorName1 = colorName1;
	}

	public String getColorName2() {
		return colorName2;
	}

	public void setColorName2(String colorName2) {
		this.colorName2 = colorName2;
	}

	public String getColorName3() {
		return colorName3;
	}

	public void setColorName3(String colorName3) {
		this.colorName3 = colorName3;
	}

	public String getColorName4() {
		return colorName4;
	}

	public void setColorName4(String colorName4) {
		this.colorName4 = colorName4;
	}

	public String getColorName5() {
		return colorName5;
	}

	public void setColorName5(String colorName5) {
		this.colorName5 = colorName5;
	}

}
