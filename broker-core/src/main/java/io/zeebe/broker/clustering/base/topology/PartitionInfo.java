/*
 * Zeebe Broker Core
 * Copyright © 2017 camunda services GmbH (info@camunda.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.zeebe.broker.clustering.base.topology;

import java.util.Objects;

import io.zeebe.util.buffer.BufferUtil;
import org.agrona.DirectBuffer;

public class PartitionInfo
{
    private final DirectBuffer topicName;
    private final int paritionId;
    private final int replicationFactor;

    public PartitionInfo(final DirectBuffer topicName, final int paritionId, final int replicationFactor)
    {
        this.topicName = topicName;
        this.paritionId = paritionId;
        this.replicationFactor = replicationFactor;
    }

    public DirectBuffer getTopicName()
    {
        return topicName;
    }

    public String getTopicNameAsString()
    {
        return BufferUtil.bufferAsString(topicName);
    }

    public int getPartitionId()
    {
        return paritionId;
    }

    public int getReplicationFactor()
    {
        return replicationFactor;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        final PartitionInfo that = (PartitionInfo) o;
        return paritionId == that.paritionId && replicationFactor == that.replicationFactor && BufferUtil.equals(topicName, that.topicName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(topicName, paritionId, replicationFactor);
    }

    @Override
    public String toString()
    {
        return String.format("Partition{topic=%s, partitionId=%d, replicationFactor=%d}", getTopicNameAsString(), paritionId, replicationFactor);
    }
}
