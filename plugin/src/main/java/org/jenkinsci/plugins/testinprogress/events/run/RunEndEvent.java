package org.jenkinsci.plugins.testinprogress.events.run;

import org.jenkinsci.plugins.testinprogress.messages.MessageIds;

/**
 * Event used when a test run ends
 * 
 * @author Cedric Chabanois (cchabanois at gmail.com)
 * 
 */
public class RunEndEvent extends AbstractRunTestEvent {
	private final long elapsedTime;

	public RunEndEvent(long timestamp, long elapsedTime) {
		super(timestamp);
		this.elapsedTime = elapsedTime;
	}

	public String getType() {
		return "RUNTIME";
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public String toString(boolean includeTimeStamp) {
		return (includeTimeStamp ? Long.toString(getTimestamp())+ " " : "")
				+ MessageIds.TEST_RUN_END + elapsedTime;
	}

	@Override
	public String toString() {
		return toString(true);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (elapsedTime ^ (elapsedTime >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RunEndEvent other = (RunEndEvent) obj;
		if (elapsedTime != other.elapsedTime)
			return false;
		return true;
	}

	


}
