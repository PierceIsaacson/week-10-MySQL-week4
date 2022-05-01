package entity;

public class Gpu {

	private int gpuId;
	private String gpuName;
	
	public Gpu(int gpuId, String gpuName) {
		this.setGpuId(gpuId);
		this.setGpuName(gpuName);
		
	}

	public int getGpuId() {
		return gpuId;
	}

	public void setGpuId(int gpuId) {
		this.gpuId = gpuId;
	}

	public String getGpuName() {
		return gpuName;
	}

	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
	}
}
